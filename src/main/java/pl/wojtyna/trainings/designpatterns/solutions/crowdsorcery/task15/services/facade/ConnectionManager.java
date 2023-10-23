package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services.facade;

import java.sql.Connection;

public interface ConnectionManager {

    Connection getConnection();
}
