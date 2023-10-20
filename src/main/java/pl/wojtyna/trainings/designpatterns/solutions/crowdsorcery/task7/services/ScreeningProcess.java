package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.annotations.ChainOfResponsibilityPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

@ChainOfResponsibilityPattern
public interface ScreeningProcess {

    ScreeningResult verify(Investor investor);
}
