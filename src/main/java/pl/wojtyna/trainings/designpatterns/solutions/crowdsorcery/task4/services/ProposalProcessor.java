package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.services;

import pl.wojtyna.trainings.designpatterns.annotations.StrategyPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.domain.Project;

@StrategyPattern
public interface ProposalProcessor {

    String process(Project proposal);
}
