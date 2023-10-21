package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class VerificationRequired implements ProjectState {

    private final Project project;

    public VerificationRequired(Project project) {
        this.project = project;
    }

    @Override
    public String name() {
        return "VERIFICATION_REQUIRED";
    }

    @Override
    public void changeState(String state) {
        if ("REJECTED".equals(state)) {
            project.setState(new Rejected(project));
        }
        else if ("FUNDRAISING".equals(state)) {
            project.setState(new Fundraising(project));
        }
        else {
            throw new IllegalArgumentException("Cannot change state from VERIFICATION_REQUIRED to " + state);
        }
    }
}
