package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task15.services;

public interface RestClient {

    String get(String url);

    void post(String url, String body);
}
