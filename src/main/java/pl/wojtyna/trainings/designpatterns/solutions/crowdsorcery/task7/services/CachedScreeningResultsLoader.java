package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class CachedScreeningResultsLoader implements ScreeningProcess {

    private final ScreeningProcess next;

    public CachedScreeningResultsLoader(ScreeningProcess next) {
        this.next = next;
    }

    @Override
    public ScreeningResult verify(Investor investor) {
        var screeningResult = getCachedResult(investor);
        if (screeningResult != null) {
            return screeningResult;
        }
        else {
            return next.verify(investor);
        }
    }

    private ScreeningResult getCachedResult(Investor investor) {
        return null;
    }
}
