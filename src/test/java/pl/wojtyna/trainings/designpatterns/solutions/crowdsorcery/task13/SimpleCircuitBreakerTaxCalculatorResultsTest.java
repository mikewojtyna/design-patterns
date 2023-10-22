package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task13;

import org.junit.jupiter.api.Test;

class SimpleCircuitBreakerTaxCalculatorResultsTest {

    @Test
    void cachingExample() {
        TaxCalculator unreliableTaxCalculator = new UnreliableTaxCalculator();
        TaxCalculator circuitBreakerTaxCalculator = new SimpleCircuitBreakerTaxCalculator(unreliableTaxCalculator);

        var project = new Project();
        for (int i = 0; i < 100; i++) {
            System.out.println("Calling circuit breaker tax calculator proxy for " + i + " time");
            var tax = circuitBreakerTaxCalculator.calculate(project);
            System.out.println("Tax: " + tax);
            System.out.println();
            System.out.println();
        }
    }
}
