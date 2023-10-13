package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.ProjectId;

public interface DefaultHandlingService {

    void markProjectAsDefaulted(ProjectId projectId);

    void recover(ProjectId projectId);

    void markProjectAsRecovered(ProjectId projectId);
}
