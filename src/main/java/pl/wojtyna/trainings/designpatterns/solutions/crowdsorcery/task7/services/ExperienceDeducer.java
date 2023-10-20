package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class ExperienceDeducer implements ScreeningProcess {

    private final ScreeningProcess next;

    public ExperienceDeducer(ScreeningProcess next) {
        this.next = next;
    }

    @Override
    public ScreeningResult verify(Investor investor) {
        useExtraDataToDeduceInvestorExperience(IdDocumentHolder.get());
        return next.verify(investor);
    }

    private void useExtraDataToDeduceInvestorExperience(IdDocument idDocument) {
        if (isExperienced(idDocument.getSomeExtraData())) {
            // mark investor as experienced
        }
    }

    private boolean isExperienced(String someExtraData) {
        throw new UnsupportedOperationException();
    }
}
