package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;

public class AlwaysPolandLocationFinder implements LocationFinder {

    @Override
    public String locationOf(Project project) {
        return "Poland";
    }
}
