package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.listeners;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Event;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.ProjectAcceptedEvent;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.ProjectRejectedEvent;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services.EventSubscriber;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services.SlackNotifications;

import java.util.Set;

public class SlackNotificationsSubscriber implements EventSubscriber {

    private final Set<Class<? extends Event>> supportedEvents = Set.of(ProjectAcceptedEvent.class,
                                                                       ProjectRejectedEvent.class);
    private final SlackNotifications slackNotifications;

    public SlackNotificationsSubscriber(SlackNotifications slackNotifications) {this.slackNotifications = slackNotifications;}

    @Override
    public void handle(Event event) {
        System.out.println("Sending slack notification for " + event.getClass().getSimpleName());
        slackNotifications.sendSlackMessage("Some message");
    }

    @Override
    public boolean supports(Class<? extends Event> type) {
        return supportedEvents.contains(type);
    }
}
