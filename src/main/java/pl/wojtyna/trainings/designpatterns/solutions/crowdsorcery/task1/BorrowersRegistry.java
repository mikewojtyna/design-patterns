package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.Borrower;

import java.util.List;

public interface BorrowersRegistry {

    void register(Borrower borrower);

    void unregister(Borrower borrower);

    List<Borrower> getBorrowers();
}
