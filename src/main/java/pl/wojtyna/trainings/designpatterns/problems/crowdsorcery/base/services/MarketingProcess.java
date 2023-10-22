package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;

public interface MarketingProcess {

    void beginCampaign(String campaignName, Project project);
}
