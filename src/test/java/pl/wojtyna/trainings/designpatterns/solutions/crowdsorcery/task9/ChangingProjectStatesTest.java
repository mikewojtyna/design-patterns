package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.services.FundraisingService;

class ChangingProjectStatesTest {

    @Test
    void changeStates() {
        var fundraisingService = new FundraisingService();
        // happy path
        System.out.println("Happy path");
        System.out.println("====================================");
        var project = fundraisingService.createProposalDraft("My project",
                                                             "My description",
                                                             Money.of(CurrencyUnit.EUR, 999_999));
        fundraisingService.proposeProject(project);
        fundraisingService.accept(project);
        fundraisingService.startFundraising(project);

        // cannot accept project with goal higher than 1_000_000
        System.out.println("Expensive project case");
        System.out.println("====================================");
        var expensiveProject = fundraisingService.createProposalDraft("Expensive project",
                                                                      "This is expensive project",
                                                                      Money.of(CurrencyUnit.EUR, 1_000_000));
        fundraisingService.proposeProject(expensiveProject);
        fundraisingService.accept(expensiveProject);
        fundraisingService.startFundraising(expensiveProject);
    }

    @Test
    void invalidTransitions() {
        var fundraisingService = new FundraisingService();
        // invalid transitions
        System.out.println("Invalid transitions");
        System.out.println("====================================");
        var project = fundraisingService.createProposalDraft("My project",
                                                             "My description",
                                                             Money.of(CurrencyUnit.EUR, 999_999));
        fundraisingService.proposeProject(project);
        fundraisingService.startFundraising(project);
    }
}
