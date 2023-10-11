package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment;

import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvent;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.Deposit;

public record PaymentVerified(Deposit deposit) implements DomainEvent {
}
