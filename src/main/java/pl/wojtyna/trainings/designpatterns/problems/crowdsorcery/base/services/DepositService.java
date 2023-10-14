package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investor;

import java.util.HashMap;
import java.util.Map;

public class DepositService {

    private final Map<Investor, Money> investorDeposits = new HashMap<>();
    private final Map<Borrower, Money> borrowerDeposits = new HashMap<>();

    public synchronized Money get(Investor investor) {
        return investorDeposits.get(investor);
    }

    public synchronized Money get(Borrower borrower) {
        return borrowerDeposits.get(borrower);
    }

    public synchronized void deposit(Money amount, Investor investor) {
        investorDeposits.merge(investor, amount, Money::plus);
    }

    public synchronized void deposit(Money amount, Borrower borrower) {
        borrowerDeposits.merge(borrower, amount, Money::plus);
    }

    public synchronized void withdraw(Money amount, Investor investor) {
        investorDeposits.merge(investor, amount, Money::minus);
    }

    public synchronized void withdraw(Money amount, Borrower borrower) {
        borrowerDeposits.merge(borrower, amount, Money::minus);
    }
}
