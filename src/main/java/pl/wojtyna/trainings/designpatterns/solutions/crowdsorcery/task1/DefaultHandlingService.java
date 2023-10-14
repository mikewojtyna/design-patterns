package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

public interface DefaultHandlingService {

    void markProjectAsDefaulted(ProjectId projectId);

    void recover(ProjectId projectId);

    void markProjectAsRecovered(ProjectId projectId);
}
