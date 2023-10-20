package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class ExpirationDateCheckerStep implements ScreeningProcess {

    private final ScreeningProcess next;

    public ExpirationDateCheckerStep(ScreeningProcess next) {this.next = next;}

    @Override
    public ScreeningResult verify(Investor investor) {
        if (!checkExpirationDateOf(IdDocumentHolder.get())) {
            return ScreeningResult.REJECTED;
        }
        return next.verify(investor);
    }

    private boolean checkExpirationDateOf(IdDocument idDocument) {
        return false;
    }

}
