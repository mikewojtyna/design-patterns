package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.infrastructure;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.services.borrowersregistry.BorrowersRegistry;

public class BorrowersRegistryFactory {

    public BorrowersRegistry borrowersRegistry() {
        return BorrowersRegistry.create();
    }
}
