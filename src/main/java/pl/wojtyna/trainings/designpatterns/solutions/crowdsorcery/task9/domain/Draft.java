package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

public class Draft implements ProjectState {

    private final Project project;

    public Draft(Project project) {
        this.project = project;
    }

    @Override
    public void changeState(String state) {
        if ("PENDING".equals(state)) {
            project.setState(new Pending(project));
        }
    }

    @Override
    public String name() {
        return "DRAFT";
    }

    @Override
    public void activate() {
        project.setProposal(false);
        project.setProject(false);
    }
}
