package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task9.services;

import pl.wojtyna.trainings.designpatterns.annotations.StrategyPattern;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task9.domain.Project;

@StrategyPattern
public interface ProposalProcessor {

    String process(Project proposal);
}
