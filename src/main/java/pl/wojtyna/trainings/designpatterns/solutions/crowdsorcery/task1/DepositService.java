package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.InvestorId;

public interface DepositService {

    void makeDeposit(Money money, InvestorId investorId);

    void withdraw(Money money, InvestorId investorId);
}
