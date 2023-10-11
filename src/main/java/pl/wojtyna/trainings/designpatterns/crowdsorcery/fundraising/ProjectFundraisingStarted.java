package pl.wojtyna.trainings.designpatterns.crowdsorcery.fundraising;

import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvent;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.invest.Investor;

public record ProjectFundraisingStarted(Investor investor, ProjectForm projectForm) implements DomainEvent {

}
