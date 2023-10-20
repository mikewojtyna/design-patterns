package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task6.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task6.domain.Project;

public interface LocationFinder {

    String locationOf(Project project);
}
