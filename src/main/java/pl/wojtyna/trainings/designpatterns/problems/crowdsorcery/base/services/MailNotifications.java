package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

public interface MailNotifications {

    void sendMail(String to, String subject, String body);
}
