package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.services;

import pl.wojtyna.trainings.designpatterns.annotations.TemplateMethodPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.ScreeningResult;

@TemplateMethodPattern
public abstract class KnowYourInvestorProcedures {

    private final IdDocumentDatabase idDocumentDatabase;
    private final CacheManager cacheManager;

    public KnowYourInvestorProcedures(IdDocumentDatabase idDocumentDatabase, CacheManager cacheManager) {
        this.idDocumentDatabase = idDocumentDatabase;
        this.cacheManager = cacheManager;
    }

    public ScreeningResult screen(Investor investor) {
        System.out.println("screening investor: " + investor);
        // Step 1
        System.out.println("Step 1");
        var screeningResult = cacheManager.getCachedResult(investor);
        System.out.println("cached screening result: " + screeningResult);
        if (screeningResult != null) {
            return screeningResult;
        }
        // Step 2
        System.out.println("Step 2");
        System.out.println("looking up id document for investor: " + investor);
        var idDocument = idDocumentDatabase.findBy(investor);
        var checkIdDocumentResult = checkIdDocument(idDocument);
        System.out.println("id document result: " + checkIdDocumentResult);
        if (checkIdDocumentResult != null) {
            return checkIdDocumentResult;
        }
        // Step 3
        System.out.println("Step 3");
        System.out.println("checking id document expiration date");
        var checkExpirationDateResult = checkExpirationDate(idDocument);
        System.out.println("expiration date result: " + checkExpirationDateResult);
        if (checkExpirationDateResult != null) {
            return checkExpirationDateResult;
        }
        // Step 4
        System.out.println("Step 4");
        System.out.println("verifying investor name");
        var verifyInvestorNameResult = verifyInvestorName(investor);
        System.out.println("investor name result: " + verifyInvestorNameResult);
        if (verifyInvestorNameResult != null) {
            return verifyInvestorNameResult;
        }
        // Step 5
        System.out.println("Step 5");
        System.out.println("deducing investor experience");
        deduceInvestorExperience(idDocument);
        return ScreeningResult.VERIFIED;
    }

    protected abstract ScreeningResult checkIdDocument(IdDocument idDocument);

    protected abstract ScreeningResult verifyInvestorName(Investor investor);

    protected abstract ScreeningResult checkExpirationDate(IdDocument idDocument);

    protected abstract void deduceInvestorExperience(IdDocument idDocument);

}
