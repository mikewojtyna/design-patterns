package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

public interface FeesCalculator {

    Money feeFor(Project project);
}
