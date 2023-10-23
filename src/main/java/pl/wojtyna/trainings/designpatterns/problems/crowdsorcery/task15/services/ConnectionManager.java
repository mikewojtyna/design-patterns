package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task15.services;

import java.sql.Connection;

public interface ConnectionManager {

    Connection getConnection();
}
