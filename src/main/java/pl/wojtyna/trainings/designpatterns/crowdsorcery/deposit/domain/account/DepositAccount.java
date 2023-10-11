package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvents;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DepositAccount {

    private final AccountId id;
    private final List<PendingDeposit> pendingDeposits;
    private Money balance;

    public DepositAccount(AccountId id) {
        this.id = id;
        pendingDeposits = new ArrayList<>();
        balance = Money.zero(CurrencyUnit.USD);
    }

    public DomainEvents make(Deposit deposit) {
        pendingDeposits.add(PendingDeposit.of(deposit));
        return DomainEvents.of(new DepositInitiated(deposit));
    }

    public DomainEvents confirm(Deposit deposit) {
        if (pendingDeposits.removeIf(pendingDeposit -> pendingDeposit.deposit().equals(deposit))) {
            balance = balance.plus(deposit.amount());
            return DomainEvents.of(new DepositConfirmed(deposit));
        }
        return DomainEvents.empty();
    }

    public DomainEvents withdraw(Money amount) {
        if (balance.isLessThan(amount)) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance = balance.minus(amount);
        return DomainEvents.of(new WithdrawalMade(amount));
    }

    @Identity
    public AccountId id() {
        return id;
    }
}
