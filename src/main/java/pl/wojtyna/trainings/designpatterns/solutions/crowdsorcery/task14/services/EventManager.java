package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Event;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventManager implements EventPublisher, EventSubscribers {

    private final Queue<EventSubscriber> subscribers = new ConcurrentLinkedQueue<>();

    @Override
    public void publish(Event event) {
        subscribers.stream().filter(eventSubscriber -> eventSubscriber.supports(event.getClass()))
                   .forEach(eventSubscriber -> eventSubscriber.handle(event));
    }

    @Override
    public void subscribe(EventSubscriber subscriber) {
        subscribers.add(subscriber);
    }
}
