package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class AlwaysVerifiedTerminator implements ScreeningProcess {

    @Override
    public ScreeningResult verify(Investor investor) {
        return ScreeningResult.VERIFIED;
    }
}
