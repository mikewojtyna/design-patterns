package pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.invest;

import java.util.List;

public record InvestmentDecisions() {

    public List<InvestmentDecision> all() {
        throw new UnsupportedOperationException();
    }
}
