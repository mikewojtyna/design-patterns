package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task6.domain.Project;

public interface LocationFinder {

    String locationOf(Project project);
}
