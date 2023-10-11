package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account;

import org.jmolecules.ddd.annotation.ValueObject;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvent;

@ValueObject
public record DepositInitiated(Deposit deposit) implements DomainEvent {
}
