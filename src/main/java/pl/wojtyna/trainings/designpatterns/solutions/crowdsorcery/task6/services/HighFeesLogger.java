package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.DecoratorPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

@DecoratorPattern
public class HighFeesLogger implements FeesCalculator {

    private final FeesCalculator feesCalculator;

    public HighFeesLogger(FeesCalculator feesCalculator) {
        this.feesCalculator = feesCalculator;
    }

    @Override
    public Money feeFor(Project project) {
        var fee = feesCalculator.feeFor(project);
        if (fee.isGreaterThan(Money.of(CurrencyUnit.EUR, 1000))) {
            System.out.println("Fees are over 1000 EUR! Fees: " + fee.getAmount() + " EUR");
        }
        return fee;
    }
}
