package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

public interface FinancingService {

    void release(ProjectId projectId);

    void financeAllProjects();
}
