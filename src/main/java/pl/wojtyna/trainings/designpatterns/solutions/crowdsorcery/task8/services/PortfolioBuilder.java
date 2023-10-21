package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services;

import pl.wojtyna.trainings.designpatterns.annotations.BuilderPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investment;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investor;

import java.util.List;

@BuilderPattern
public interface PortfolioBuilder<R> {

    PortfolioBuilder<R> withId(String id);

    PortfolioBuilder<R> withTitle(String title);

    PortfolioBuilder<R> withDescription(String description);

    PortfolioBuilder<R> withInvestments(List<Investment> investments);

    PortfolioBuilder<R> withInvestor(Investor investor);

    default R getLastResult() {
        return build();
    }

    R build();
}
