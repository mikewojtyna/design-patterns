package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investment;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task8.domain.PortfolioRecord;

import java.util.List;

public class PortfolioRecordBuilder implements PortfolioBuilder<PortfolioRecord> {

    private String id = "";
    private String title = "";
    private String description = "";

    @Override
    public PortfolioBuilder<PortfolioRecord> withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public PortfolioBuilder<PortfolioRecord> withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public PortfolioBuilder<PortfolioRecord> withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public PortfolioBuilder<PortfolioRecord> withInvestments(List<Investment> investments) {
        return this;
    }

    @Override
    public PortfolioBuilder<PortfolioRecord> withInvestor(Investor investor) {
        return this;
    }

    @Override
    public PortfolioRecord build() {
        return new PortfolioRecord(id, title, description);
    }
}
