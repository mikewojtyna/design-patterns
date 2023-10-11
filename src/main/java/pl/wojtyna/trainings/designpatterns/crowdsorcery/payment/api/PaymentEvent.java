package pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api;

import org.jmolecules.ddd.annotation.ValueObject;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvent;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.integration.IntegrationEvent;

@ValueObject
public record PaymentEvent() implements IntegrationEvent, DomainEvent {
}
