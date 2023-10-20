package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.DecoratorPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

import java.math.RoundingMode;

@DecoratorPattern
public class LocationFeeCalculator implements FeesCalculator {

    public static final double GERMANY_TAX = 0.18;
    public static final double UK_TAX = 0.20;
    public static final double POLAND_TAX = 0.19;
    private final LocationFinder locationFinder = new AlwaysPolandLocationFinder();
    private final FeesCalculator delegee;

    public LocationFeeCalculator(FeesCalculator delegee) {this.delegee = delegee;}

    public LocationFeeCalculator() {
        delegee = null;
    }

    @Override
    public Money feeFor(Project project) {
        String location = locationFinder.locationOf(project);
        double locationTax = switch (location) {
            case "Poland" -> POLAND_TAX;
            case "Germany" -> GERMANY_TAX;
            case "UK" -> UK_TAX;
            default -> throw new IllegalArgumentException("Unknown location: " + location);
        };
        var baseEarnings = project.getGoal().multipliedBy(project.getInterestRate(), RoundingMode.HALF_UP);
        var locationFee = baseEarnings.multipliedBy(locationTax, RoundingMode.HALF_UP);
        if (delegee == null) {
            return locationFee;
        }
        return locationFee.plus(delegee.feeFor(project));
    }
}
