package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Default implements ProjectState {

    public Default(Project project) {}

    @Override
    public void changeState(String state) {
        throw new IllegalArgumentException("Cannot change state of default project");
    }

    @Override
    public String name() {
        return "DEFAULT";
    }
}
