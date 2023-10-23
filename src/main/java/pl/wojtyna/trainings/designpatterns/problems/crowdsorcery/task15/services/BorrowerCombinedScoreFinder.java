package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task15.services;

import java.sql.SQLException;

public class BorrowerCombinedScoreFinder {

    private final ConnectionManager connectionManager;
    private final JdbcDatabase jdbcDatabase;
    private final MongoDatabase mongoDatabase;

    public BorrowerCombinedScoreFinder(ConnectionManager connectionManager,
                                       JdbcDatabase jdbcDatabase,
                                       MongoDatabase mongoDatabase) {
        this.connectionManager = connectionManager;
        this.jdbcDatabase = jdbcDatabase;
        this.mongoDatabase = mongoDatabase;
    }

    public int borrowerScore(String borrowerId) {
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
                    return (sqlCreditScore + legacyPoints / 2) + 1;
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }

    private record BorrowerDocument(String id, String sqlId, int legacyPoints) {
    }
}
