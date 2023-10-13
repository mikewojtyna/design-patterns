package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.ProjectId;

public interface FinancingService {

    void release(ProjectId projectId);

    void financeAllProjects();
}
