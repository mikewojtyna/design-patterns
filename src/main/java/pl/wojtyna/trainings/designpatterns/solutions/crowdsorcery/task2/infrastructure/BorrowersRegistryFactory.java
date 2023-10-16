package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.infrastructure;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.services.BorrowersRegistry;

public class BorrowersRegistryFactory {

    public BorrowersRegistry borrowersRegistry() {
        return BorrowersRegistry.create();
    }
}
