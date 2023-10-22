package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.ScreeningResult;

public class ScreeningStepsHandler extends KnowYourInvestorProcedures {

    public ScreeningStepsHandler(IdDocumentDatabase idDocumentDatabase, CacheManager cacheManager) {
        super(idDocumentDatabase, cacheManager);
    }

    @Override
    protected ScreeningResult verifyInvestorName(Investor investor) {
        if (!verifyName(investor)) {
            return ScreeningResult.REJECTED;
        }
        return null;
    }

    @Override
    protected ScreeningResult checkExpirationDate(IdDocument idDocument) {
        if (!checkExpirationDateOf(idDocument)) {
            return ScreeningResult.REJECTED;
        }
        return null;
    }

    @Override
    protected void deduceInvestorExperience(IdDocument idDocument) {
        if (isExperienced(idDocument.getSomeExtraData())) {
            // mark investor as experienced
        }
    }

    @Override
    protected ScreeningResult checkIdDocument(IdDocument idDocument) {
        if (idDocument == null) {
            return ScreeningResult.REJECTED;
        }
        return null;
    }

    private boolean isExperienced(String someExtraData) {
        throw new UnsupportedOperationException();
    }

    private boolean checkExpirationDateOf(IdDocument idDocument) {
        return false;
    }

    private boolean verifyName(Investor investor) {
        throw new UnsupportedOperationException();
    }
}
