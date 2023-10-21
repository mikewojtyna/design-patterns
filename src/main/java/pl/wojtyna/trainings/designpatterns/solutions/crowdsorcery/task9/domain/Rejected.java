package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Rejected implements ProjectState {

    public Rejected(Project project) {}

    @Override
    public void changeState(String state) {
        throw new IllegalArgumentException("Cannot change state of rejected project");
    }

    @Override
    public String name() {
        return "REJECTED";
    }
}
