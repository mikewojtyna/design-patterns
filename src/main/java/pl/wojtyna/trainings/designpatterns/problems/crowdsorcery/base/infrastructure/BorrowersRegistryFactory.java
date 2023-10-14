package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.infrastructure;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services.BorrowersRegistry;

public class BorrowersRegistryFactory {

    public BorrowersRegistry borrowersRegistry() {
        return new BorrowersRegistry();
    }
}
