package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.doman.AccountNumber;

public interface AccountNumbers {

    AccountNumber findBy(String name);
}
