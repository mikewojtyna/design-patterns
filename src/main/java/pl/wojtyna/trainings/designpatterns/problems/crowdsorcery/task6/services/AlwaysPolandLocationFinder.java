package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task6.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task6.domain.Project;

public class AlwaysPolandLocationFinder implements LocationFinder {

    @Override
    public String locationOf(Project project) {
        return "Poland";
    }
}
