package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services.*;

public class EarningsCalculatorTest {

    @Test
    void usingDecoratorPattern() {
        var earningsCalculator = new EarningsCalculator(new HighFeesLogger(new BigProjectFeeCalculator(new PlatformFeeCalculator(
            new BuzzwordsFeeCalculator()))));
        var project = new Project();
        project.setGoal(Money.of(CurrencyUnit.EUR, 1_000_000));
        project.setInterestRate(0.1);
        project.setDescription("This project uses blockchain, AI and multiverse technologies");
        var investor = new Investor("George", "Martin");
        var expectedEarnings = earningsCalculator.expectedEarnings(project, investor);
        System.out.println("Expected earnings: " + expectedEarnings);
    }
}
