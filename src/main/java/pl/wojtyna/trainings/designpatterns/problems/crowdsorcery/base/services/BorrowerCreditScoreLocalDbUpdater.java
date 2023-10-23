package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import java.sql.SQLException;

public class BorrowerCreditScoreLocalDbUpdater {

    private final ConnectionManager connectionManager;
    private final JdbcDatabase jdbcDatabase;
    private final MongoDatabase mongoDatabase;

    public BorrowerCreditScoreLocalDbUpdater(ConnectionManager connectionManager,
                                             JdbcDatabase jdbcDatabase,
                                             MongoDatabase mongoDatabase) {
        this.connectionManager = connectionManager;
        this.jdbcDatabase = jdbcDatabase;
        this.mongoDatabase = mongoDatabase;
    }

    public void updateCreditScore(int bonusPoints, String borrowerId) {
        var object = mongoDatabase.getDocument(borrowerId);
        if (object instanceof BorrowerDocument borrowerDocument) {
            var legacyPoints = borrowerDocument.legacyPoints();
            try (var connection = connectionManager.getConnection()) {
                var preparedStatement = connection.prepareStatement("SELECT * FROM borrowers WHERE id=?");
                preparedStatement.setString(1, borrowerDocument.sqlId());
                var resultSet = jdbcDatabase.executeQuery(preparedStatement, connection);
                Integer sqlCreditScore = null;
                if (resultSet.next()) {
                    sqlCreditScore = resultSet.getInt("credit_score");
                }
                if (resultSet.next()) {
                    throw new RuntimeException("More than one borrower with id " + borrowerDocument.sqlId());
                }
                if (sqlCreditScore != null) {
                    var newCreditScore = (sqlCreditScore + legacyPoints / 2) + 1 + bonusPoints;
                    var updateStatement = connection.prepareStatement("UPDATE borrowers SET credit_score=? WHERE id=?");
                    updateStatement.setInt(1, newCreditScore);
                    updateStatement.setString(2, borrowerDocument.sqlId());
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private record BorrowerDocument(String id, String sqlId, int legacyPoints) {
    }
}
