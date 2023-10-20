package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.DecoratorPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

import java.math.RoundingMode;

@DecoratorPattern
public class BuzzwordsFeeCalculator implements FeesCalculator {

    private final FeesCalculator delegee;

    public BuzzwordsFeeCalculator() {
        delegee = null;
    }

    public BuzzwordsFeeCalculator(FeesCalculator delegee) {
        this.delegee = delegee;
    }

    @Override
    public Money feeFor(Project project) {
        var goal = project.getGoal();
        var buzzwordsFee = Money.zero(CurrencyUnit.EUR);
        if (project.getDescription().contains("AI")) {
            buzzwordsFee = buzzwordsFee.plus(goal.multipliedBy(0.03, RoundingMode.HALF_UP));
        }
        if (project.getDescription().contains("blockchain")) {
            buzzwordsFee = buzzwordsFee.plus(goal.multipliedBy(0.02, RoundingMode.HALF_UP));
        }
        if (project.getDescription().contains("multiverse")) {
            buzzwordsFee = buzzwordsFee.plus(goal.multipliedBy(0.01, RoundingMode.HALF_UP));
        }
        if (delegee == null) {
            return buzzwordsFee;
        }
        return buzzwordsFee.plus(delegee.feeFor(project));
    }
}
