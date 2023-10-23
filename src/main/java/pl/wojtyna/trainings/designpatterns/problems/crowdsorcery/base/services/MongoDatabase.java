package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

public interface MongoDatabase {

    Object getDocument(String id);

    void saveDocument(Object document);
}
