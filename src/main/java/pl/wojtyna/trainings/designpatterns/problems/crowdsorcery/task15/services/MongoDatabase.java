package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task15.services;

public interface MongoDatabase {

    Object getDocument(String id);

    void saveDocument(Object document);
}
