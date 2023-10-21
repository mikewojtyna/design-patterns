package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Funded implements ProjectState {

    private final Project project;

    public Funded(Project project) {this.project = project;}

    @Override
    public void changeState(String state) {
        if ("CANCELLED".equals(state)) {
            project.setState(new Cancelled(project));
        }
        else if ("DEFAULT".equals(state)) {
            project.setState(new Default(project));
        }
        else if ("FINISHED".equals(state)) {
            project.setState(new Finished(project));
        }
        else {
            throw new IllegalArgumentException("Cannot change state from FUNDRAISING to " + state);
        }
    }

    @Override
    public String name() {
        return "FUNDED";
    }
}
