package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

import pl.wojtyna.trainings.designpatterns.annotations.StatePattern;

@StatePattern
public interface ProjectState {

    void changeState(String state);

    String name();

    default void activate() {
        // do nothing by default
    }
}
