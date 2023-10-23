package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import java.sql.Connection;

public interface ConnectionManager {

    Connection getConnection();
}
