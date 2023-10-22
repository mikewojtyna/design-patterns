package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.domain.AccountNumber;

public interface AccountNumbers {

    AccountNumber findBy(String name);
}
