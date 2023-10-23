package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task15.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface JdbcDatabase {

    void executeUpdate(PreparedStatement sql, Connection connection);

    ResultSet executeQuery(PreparedStatement sql, Connection connection);

}
