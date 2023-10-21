package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Accepted implements ProjectState {

    private final Project project;

    public Accepted(Project project) {
        this.project = project;
    }

    @Override
    public void changeState(String state) {
        if ("FUNDRAISING".equals(state)) {
            project.setState(new Fundraising(project));
        }
        else if ("CANCELLED".equals(state)) {
            project.setState(new Cancelled(project));
        }
        else {
            throw new IllegalStateException("Cannot change state from ACCEPTED to " + state);
        }
    }

    @Override
    public String name() {
        return "ACCEPTED";
    }

    @Override
    public void activate() {
        project.setProposal(false);
        project.setProject(true);
    }
}
