package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Cancelled implements ProjectState {

    public Cancelled(Project project) {

    }

    @Override
    public void changeState(String state) {
        throw new IllegalArgumentException("Cannot change state of cancelled project");
    }

    @Override
    public String name() {
        return "CANCELLED";
    }
}
