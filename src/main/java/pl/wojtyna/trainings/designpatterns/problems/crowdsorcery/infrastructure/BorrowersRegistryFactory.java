package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.infrastructure;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services.BorrowersRegistry;

public class BorrowersRegistryFactory {

    public BorrowersRegistry borrowersRegistry() {
        return new BorrowersRegistry();
    }
}
