package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

public interface RestClient {

    String get(String url);

    void post(String url, String body);
}
