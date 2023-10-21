package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Fundraising implements ProjectState {

    private final Project project;

    public Fundraising(Project project) {this.project = project;}

    @Override
    public String name() {
        return "FUNDRAISING";
    }

    @Override
    public void changeState(String state) {
        if ("FUNDED".equals(state)) {
            if (project.deposit().isGreaterThan(project.goal()) || project.deposit().isEqual(project.goal())) {
                project.setState(new Funded(project));
            }
        }
        else if ("CANCELLED".equals(state)) {
            project.setState(new Cancelled(project));
        }
        else {
            throw new IllegalArgumentException("Cannot change state from FUNDRAISING to " + state);
        }
    }
}
