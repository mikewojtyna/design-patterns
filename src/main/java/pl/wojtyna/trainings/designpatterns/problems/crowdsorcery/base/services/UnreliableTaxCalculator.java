package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;

public class UnreliableTaxCalculator implements TaxCalculator {

    @Override
    public double calculate(Project project) {
        double randomTax = Math.random();
        if (randomTax < 0.5) {
            throw new RuntimeException("Service failed");
        }
        return randomTax;
    }
}
