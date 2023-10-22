package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Portfolio;

public interface PortfolioDatabase {

    Portfolio findById(String id);

    void save(Portfolio portfolio);
}
