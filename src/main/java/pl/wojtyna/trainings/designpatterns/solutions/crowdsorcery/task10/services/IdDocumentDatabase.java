package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.Investor;

public interface IdDocumentDatabase {

    IdDocument findBy(Investor investor);
}
