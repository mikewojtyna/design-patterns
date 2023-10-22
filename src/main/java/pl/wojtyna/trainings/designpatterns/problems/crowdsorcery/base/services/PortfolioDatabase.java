package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Portfolio;

public interface PortfolioDatabase {

    Portfolio findById(String id);

    void save(Portfolio portfolio);
}
