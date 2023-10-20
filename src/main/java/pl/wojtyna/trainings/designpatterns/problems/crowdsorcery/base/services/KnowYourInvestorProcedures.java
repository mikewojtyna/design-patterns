package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investor;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.ScreeningResult;

public class KnowYourInvestorProcedures {

    public ScreeningResult screen(Investor investor) {
        // Step 1
        var screeningResult = getCachedResult(investor);
        if (screeningResult != null) {
            return screeningResult;
        }
        // Step 2
        var idDocument = lookUpIdDocumentFromSomeDatabase(investor);
        if (idDocument == null) {
            return ScreeningResult.REJECTED;
        }
        // Step 3
        enhanceIdDocumentWithSomeExtraDataRequiredForFurtherProcessing(idDocument);
        // Step 4
        if (!checkExpirationDateOf(idDocument)) {
            return ScreeningResult.REJECTED;
        }
        // Step 5
        if (!verifyName(investor)) {
            return ScreeningResult.REJECTED;
        }
        // Step 6
        useExtraDataToDeduceInvestorExperience(idDocument);
        return ScreeningResult.VERIFIED;
    }

    private void useExtraDataToDeduceInvestorExperience(IdDocument idDocument) {
        if(isExperienced(idDocument.getSomeExtraData())) {
            // mark investor as experienced
        }
    }

    private boolean isExperienced(String someExtraData) {
        throw new UnsupportedOperationException();
    }

    private void enhanceIdDocumentWithSomeExtraDataRequiredForFurtherProcessing(IdDocument idDocument) {
        idDocument.setSomeExtraData("some extra data");
    }

    private ScreeningResult getCachedResult(Investor investor) {
        throw new UnsupportedOperationException();
    }

    private boolean verifyName(Investor investor) {
        throw new UnsupportedOperationException();
    }

    private boolean checkExpirationDateOf(IdDocument idDocument) {
        throw new UnsupportedOperationException();
    }

    private IdDocument lookUpIdDocumentFromSomeDatabase(Investor investor) {
        throw new UnsupportedOperationException();
    }
}
