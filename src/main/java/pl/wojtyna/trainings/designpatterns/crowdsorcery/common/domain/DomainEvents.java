package pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomainEvents {

    private final List<DomainEvent> eventList;

    public DomainEvents() {
        eventList = new LinkedList<>();
    }

    private DomainEvents(List<DomainEvent> eventList) {
        this.eventList = eventList;
    }

    public static DomainEvents empty() {
        return new DomainEvents();
    }

    public Stream<DomainEvent> stream() {
        return eventList.stream();
    }

    public static DomainEvents of(DomainEvent... eventsArray) {
        return new DomainEvents(Arrays.stream(eventsArray).collect(Collectors.toList()));
    }

    public boolean hasOccurredEventOfType(Class<? extends DomainEvent> type) {
        return stream().map(DomainEvent::getClass).anyMatch(type::isAssignableFrom);
    }

    public boolean hasAtLeastOneEventMatching(Predicate<DomainEvent> predicate) {
        return eventList.stream().anyMatch(predicate);
    }
}
