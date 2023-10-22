package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

public interface Command {

    void execute();

    void undo();

    CommandId id();
}
