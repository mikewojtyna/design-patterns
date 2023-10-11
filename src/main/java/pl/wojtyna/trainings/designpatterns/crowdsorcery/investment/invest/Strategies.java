package pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.invest;

import java.util.Optional;

public interface Strategies {

    Optional<Strategy> activeStrategyOf(InvestorId investorId);

    void set(Strategy strategy);
}
