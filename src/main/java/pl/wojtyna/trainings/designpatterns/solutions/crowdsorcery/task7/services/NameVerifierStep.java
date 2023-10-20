package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class NameVerifierStep implements ScreeningProcess {

    private final ScreeningProcess next;

    public NameVerifierStep(ScreeningProcess next) {
        this.next = next;
    }

    @Override
    public ScreeningResult verify(Investor investor) {
        // Step 5
        if (!verifyName(investor)) {
            return ScreeningResult.REJECTED;
        }
        return next.verify(investor);
    }

    private boolean verifyName(Investor investor) {
        return true;
    }
}
