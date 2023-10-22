package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.services;

public interface MailNotifications {

    void sendMail(String to, String subject, String body);
}
