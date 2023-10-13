package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain;

public class ProjectException extends RuntimeException {

    private final Project project;

    public ProjectException(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

}
