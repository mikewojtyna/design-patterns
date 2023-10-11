package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.events;

import org.jmolecules.ddd.annotation.ValueObject;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.integration.IntegrationEvent;

import java.math.BigDecimal;

@ValueObject
public record DepositMade(String accountId, BigDecimal amount, String currency) implements IntegrationEvent {
}
