package pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.invest;

import org.joda.money.Money;

public interface Strategy {

    InvestmentDecisions apply(Money of);
}
