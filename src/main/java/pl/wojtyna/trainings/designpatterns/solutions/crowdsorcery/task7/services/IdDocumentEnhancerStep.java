package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class IdDocumentEnhancerStep implements ScreeningProcess {

    private final ScreeningProcess next;

    public IdDocumentEnhancerStep(ScreeningProcess next) {
        this.next = next;
    }

    @Override
    public ScreeningResult verify(Investor investor) {
        enhanceIdDocumentWithSomeExtraDataRequiredForFurtherProcessing(IdDocumentHolder.get());
        return next.verify(investor);
    }

    private void enhanceIdDocumentWithSomeExtraDataRequiredForFurtherProcessing(IdDocument idDocument) {
        idDocument.setSomeExtraData("some extra data");
    }
}
