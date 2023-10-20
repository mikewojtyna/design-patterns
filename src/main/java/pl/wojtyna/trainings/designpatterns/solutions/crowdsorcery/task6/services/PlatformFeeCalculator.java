package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.DecoratorPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

import java.math.RoundingMode;

@DecoratorPattern
public class PlatformFeeCalculator implements FeesCalculator {

    private final FeesCalculator delegee;

    public PlatformFeeCalculator() {
        delegee = null;
    }

    public PlatformFeeCalculator(FeesCalculator feesCalculator) {this.delegee = feesCalculator;}

    @Override
    public Money feeFor(Project project) {
        var goal = project.getGoal();
        var platformFee = Money.of(CurrencyUnit.EUR, 5).plus(goal)
                               .multipliedBy(1 + 0.005, RoundingMode.HALF_UP);
        if (delegee == null) {
            return platformFee;
        }
        return platformFee.plus(delegee.feeFor(project));
    }
}
