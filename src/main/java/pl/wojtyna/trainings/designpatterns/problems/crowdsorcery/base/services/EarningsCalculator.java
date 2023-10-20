package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investor;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;

import java.math.RoundingMode;

public class EarningsCalculator {

    public static final double GERMANY_TAX = 0.18;
    public static final double UK_TAX = 0.20;
    public static final double VIP_DISCOUNT = 0.05;
    public static final double POLAND_TAX = 0.19;
    private final LocationFinder locationFinder = new AlwaysPolandLocationFinder();

    public Money expectedEarnings(Project project, Investor investor) {
        var goal = project.getGoal();
        var platformFee = Money.of(CurrencyUnit.EUR, 5).plus(goal)
                               .multipliedBy(1 + 0.005, RoundingMode.HALF_UP);
        // calculate everything
        var baseEarnings = goal.multipliedBy(project.getInterestRate(), RoundingMode.HALF_UP);
        var bigProjectFee = goal.isGreaterThan(Money.of(CurrencyUnit.EUR, 100000)) ? goal.multipliedBy(0.01,
                                                                                                       RoundingMode.HALF_UP) : Money.zero(
            CurrencyUnit.EUR);
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
        String location = locationFinder.locationOf(project);
        double locationTax = switch (location) {
            case "Poland" -> POLAND_TAX;
            case "Germany" -> GERMANY_TAX;
            case "UK" -> UK_TAX;
            default -> throw new IllegalArgumentException("Unknown location: " + location);
        };
        var locationFee = baseEarnings.multipliedBy(locationTax, RoundingMode.HALF_UP);
        // more and more fees will need to be supported soon
        var fees = platformFee.plus(locationFee).plus(bigProjectFee).plus(buzzwordsFee);
        if (fees.isGreaterThan(Money.of(CurrencyUnit.EUR, 1000))) {
            System.out.println("Fees are high!");
        }
        return baseEarnings.minus(fees).plus(investor.isVip() ? baseEarnings.multipliedBy(VIP_DISCOUNT,
                                                                                          RoundingMode.HALF_UP) : Money.zero(
            CurrencyUnit.EUR));
    }
}
