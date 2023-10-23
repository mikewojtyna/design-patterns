package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services.facade;

public interface RestClient {

    String get(String url);

    void post(String url, String body);
}
