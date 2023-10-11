package pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.api.eventhandlers;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainPolicy;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.events.DepositMade;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.invest.*;

@PrimaryPort
public class InvestmentPolicy implements DomainPolicy {

    private final Strategies strategies;
    private final InvestOperations investOperations;

    public InvestmentPolicy(Strategies strategies, InvestOperations investOperations) {
        this.strategies = strategies;
        this.investOperations = investOperations;
    }

    public void handle(DepositMade depositMade) {
        applyInvestmentStrategy(depositMade);
    }

    private void applyInvestmentStrategy(DepositMade depositMade) {
        strategies.activeStrategyOf(new InvestorId(depositMade.accountId())).ifPresent(strategy -> {
            var decisions = strategy.apply(Money.of(CurrencyUnit.of(depositMade.currency()), depositMade.amount()));
            investIntoDifferentAssetsBasedOn(decisions, findInvestor(depositMade));
        });
    }

    private Investor findInvestor(DepositMade depositMade) {
        throw new UnsupportedOperationException();
    }

    private void investIntoDifferentAssetsBasedOn(InvestmentDecisions decisions, Investor investor) {
        decisions.all().forEach(decision -> {
            investOperations.investInto(assetOf(decision)).some(amountOf(decision)).by(investor);
        });
    }

    private Money amountOf(InvestmentDecision decision) {
        throw new UnsupportedOperationException();
    }

    private Asset assetOf(InvestmentDecision investmentDecision) {
        throw new UnsupportedOperationException();
    }
}
