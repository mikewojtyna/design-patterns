package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Finished implements ProjectState {

    public Finished(Project project) {}

    @Override
    public String name() {
        return "FINISHED";
    }

    @Override
    public void changeState(String state) {
        throw new IllegalArgumentException("Cannot change state of finished project");
    }
}
