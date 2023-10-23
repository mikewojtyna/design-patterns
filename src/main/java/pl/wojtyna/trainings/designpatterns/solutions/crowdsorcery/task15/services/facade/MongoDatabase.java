package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services.facade;

public interface MongoDatabase {

    Object getDocument(String id);

    void saveDocument(Object document);
}
