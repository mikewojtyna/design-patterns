package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task13;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCircuitBreakerTaxCalculator implements TaxCalculator {

    private static final int MAX_TRIES = 3;
    private final Map<Project, Double> cache = new ConcurrentHashMap<>();
    private final TaxCalculator delegee;
    private int tries;

    public SimpleCircuitBreakerTaxCalculator(TaxCalculator delegee) {
        this.delegee = delegee;
        tries = 0;
    }

    @Override
    public double calculate(Project project) {
        if (tries >= MAX_TRIES) {
            System.out.println(
                "Max tries reached, returning cached value without even trying to contact the tax service");
            return cache.getOrDefault(project, 0.0);
        }
        try {
            var tax = delegee.calculate(project);
            cache.put(project, tax);
            tries = 0;
            System.out.println("Service worked, resetting tries counter. Tries: " + tries);
            return tax;
        }
        catch (Exception e) {
            tries++;
            System.out.println("Service failed, returning cached value");
            System.out.println("Tries: " + tries);
            return cache.getOrDefault(project, 0.0);
        }
    }
}
