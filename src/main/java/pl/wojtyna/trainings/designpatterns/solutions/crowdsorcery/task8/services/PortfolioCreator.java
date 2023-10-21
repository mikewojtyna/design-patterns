package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Portfolio;

public class PortfolioCreator {

    public <R> R create(Portfolio portfolio, PortfolioBuilder<R> builder) {
        return builder.withId(portfolio.getId()).withDescription(portfolio.getDescription())
                      .withTitle(portfolio.getTitle())
                      .withInvestments(portfolio.getInvestments()).withInvestor(portfolio.getInvestor()).build();
    }
}
