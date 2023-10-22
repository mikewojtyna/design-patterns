package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Event;

public interface EventSubscriber {

    void handle(Event event);

    boolean supports(Class<? extends Event> type);
}
