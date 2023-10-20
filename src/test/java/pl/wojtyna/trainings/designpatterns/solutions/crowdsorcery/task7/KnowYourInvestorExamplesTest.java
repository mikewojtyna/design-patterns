package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7;

import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services.*;

class KnowYourInvestorExamplesTest {

    @Test
    void screeningExample() {
        var knowYourInvestorProcedures = new KnowYourInvestorProcedures(
            new CachedScreeningResultsLoader(new LookUpIdDocumentStep(new IdDocumentEnhancerStep(new NameVerifierStep(
                new ExpirationDateCheckerStep(new AlwaysVerifiedTerminator()))))));

        var investor = new Investor("George", "Martin");
        var screeningResult = knowYourInvestorProcedures.screen(investor);

        System.out.println("Screening result: " + screeningResult); // try to play with changing individual screening process steps and see how the result changes
    }
}
