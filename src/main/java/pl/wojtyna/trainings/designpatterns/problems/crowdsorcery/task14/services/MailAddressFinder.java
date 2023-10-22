package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.domain.Investor;

public interface MailAddressFinder {

    String findMailAddress(Investor investor);

    String findMailAddress(Borrower borrower);
}
