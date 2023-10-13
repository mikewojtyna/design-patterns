package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Investor;

public class DepositService {

    public Money get(Investor investor) {
        return null;
    }

    void deposit(Money amount, Investor investor) {
        // ...
    }

    void lock(Money amount, Investor investor) {
        // ...
    }

    void unlock(Money amount, Investor investor) {
        // ...
    }

    void withdraw(Money amount, Investor investor) {
        // ...
    }

    void deposit(Money amount, Borrower borrower) {
        // ...
    }

    void lock(Money amount, Borrower borrower) {
        // ...
    }

    void unlock(Money amount, Borrower borrower) {
        // ...
    }

    void withdraw(Money amount, Borrower borrower) {
        // ...
    }
}
