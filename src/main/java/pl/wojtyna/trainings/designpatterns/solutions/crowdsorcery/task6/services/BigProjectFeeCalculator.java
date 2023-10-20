package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.DecoratorPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

import java.math.RoundingMode;

@DecoratorPattern
public class BigProjectFeeCalculator implements FeesCalculator {

    private final FeesCalculator delegee;

    public BigProjectFeeCalculator(FeesCalculator delegee) {
        this.delegee = delegee;
    }

    public BigProjectFeeCalculator() {
        delegee = null;
    }

    @Override
    public Money feeFor(Project project) {
        var goal = project.getGoal();
        return goal.isGreaterThan(Money.of(CurrencyUnit.EUR, 100000)) ? goal.multipliedBy(0.01,
                                                                                          RoundingMode.HALF_UP) : Money.zero(
            CurrencyUnit.EUR).plus(delegee == null ? Money.zero(CurrencyUnit.EUR) : delegee.feeFor(project));
    }
}
