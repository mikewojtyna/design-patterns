package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class LookUpIdDocumentStep implements ScreeningProcess {

    private final ScreeningProcess next;

    public LookUpIdDocumentStep(ScreeningProcess next) {
        this.next = next;
    }

    @Override
    public ScreeningResult verify(Investor investor) {
        var idDocument = lookUpIdDocumentFromSomeDatabase(investor);
        if (idDocument == null) {
            return ScreeningResult.REJECTED;
        }
        IdDocumentHolder.set(idDocument);
        return next.verify(investor);
    }

    private IdDocument lookUpIdDocumentFromSomeDatabase(Investor investor) {
        return new IdDocument();
    }
}
