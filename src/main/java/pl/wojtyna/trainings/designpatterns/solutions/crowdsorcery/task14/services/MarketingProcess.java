package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Project;

public interface MarketingProcess {

    void beginCampaign(String campaignName, Project project);
}
