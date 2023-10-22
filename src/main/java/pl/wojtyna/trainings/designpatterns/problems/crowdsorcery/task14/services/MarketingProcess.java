package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.domain.Project;

public interface MarketingProcess {

    void beginCampaign(String campaignName, Project project);
}
