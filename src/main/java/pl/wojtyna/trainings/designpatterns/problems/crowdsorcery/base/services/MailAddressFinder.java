package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investor;

public interface MailAddressFinder {

    String findMailAddress(Investor investor);

    String findMailAddress(Borrower borrower);
}
