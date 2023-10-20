package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

import java.math.RoundingMode;

public class EarningsCalculator {

    public static final double VIP_DISCOUNT = 0.05;
    private final FeesCalculator feesCalculator;

    public EarningsCalculator(FeesCalculator feesCalculator) {this.feesCalculator = feesCalculator;}

    public Money expectedEarnings(Project project, Investor investor) {
        var baseEarnings = project.getGoal().multipliedBy(project.getInterestRate(), RoundingMode.HALF_UP);
        return baseEarnings.minus(feesCalculator.feeFor(project))
                           .plus(investor.isVip() ? baseEarnings.multipliedBy(VIP_DISCOUNT,
                                                                              RoundingMode.HALF_UP) : Money.zero(
                               CurrencyUnit.EUR));
    }
}
