package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account;

import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvents;

public interface Deposits {

    DomainEvents openNewAccount();
}
