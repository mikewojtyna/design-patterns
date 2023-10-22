package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Event;

public interface EventPublisher {

    void publish(Event event);
}
