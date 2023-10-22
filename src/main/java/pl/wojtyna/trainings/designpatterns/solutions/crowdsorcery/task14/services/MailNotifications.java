package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services;

public interface MailNotifications {

    void sendMail(String to, String subject, String body);
}
