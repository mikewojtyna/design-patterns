package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvent;

public record WithdrawalMade(Money amount) implements DomainEvent {
}
