package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account;

import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvent;

public record DepositConfirmed(Deposit deposit) implements DomainEvent {}
