package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investment;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investor;

import java.util.List;

public class CompositePortfolioBuilder implements PortfolioBuilder<Void> {

    private final List<PortfolioBuilder<?>> builders;

    public CompositePortfolioBuilder(List<PortfolioBuilder<?>> builders) {
        this.builders = builders;
    }

    @Override
    public PortfolioBuilder<Void> withId(String id) {
        builders.forEach(builder -> builder.withId(id));
        return this;
    }

    @Override
    public PortfolioBuilder<Void> withTitle(String title) {
        builders.forEach(builder -> builder.withTitle(title));
        return this;
    }

    @Override
    public PortfolioBuilder<Void> withDescription(String description) {
        builders.forEach(builder -> builder.withDescription(description));
        return this;
    }

    @Override
    public PortfolioBuilder<Void> withInvestments(List<Investment> investments) {
        builders.forEach(builder -> builder.withInvestments(investments));
        return this;
    }

    @Override
    public PortfolioBuilder<Void> withInvestor(Investor investor) {
        builders.forEach(builder -> builder.withInvestor(investor));
        return this;
    }

    @Override
    public Void build() {
        return null;
    }
}
