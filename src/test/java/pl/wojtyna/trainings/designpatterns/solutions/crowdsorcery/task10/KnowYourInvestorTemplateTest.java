package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10;

import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.IdDocument;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.services.ScreeningStepsHandler;

class KnowYourInvestorTemplateTest {

    @Test
    void templateExample() {
        var knowYourInvestorProcedures = new ScreeningStepsHandler(investor -> new IdDocument(),
                                                                   investor -> null);
        var screeningResult = knowYourInvestorProcedures.screen(new Investor("George", "Martin"));
        System.out.println("screeningResult = " + screeningResult);
    }
}
