package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

import org.joda.money.Money;

public interface DepositService {

    void makeDeposit(Money money, InvestorId investorId);

    void withdraw(Money money, InvestorId investorId);
}
