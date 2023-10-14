package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task2.infrastructure;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task2.services.BorrowersRegistry;

public class BorrowersRegistryFactory {

    public BorrowersRegistry borrowersRegistry() {
        return new BorrowersRegistry();
    }
}
