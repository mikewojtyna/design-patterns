package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3.services;

import pl.wojtyna.trainings.designpatterns.annotations.StrategyPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3.domain.Project;

@StrategyPattern
public interface ProposalProcessor {

    String process(Project proposal);
}
