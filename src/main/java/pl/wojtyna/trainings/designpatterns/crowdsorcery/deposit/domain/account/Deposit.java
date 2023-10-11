package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account;

import org.jmolecules.ddd.annotation.ValueObject;
import org.joda.money.Money;

@ValueObject
public record Deposit(Money amount, AccountId accountId) {
}
