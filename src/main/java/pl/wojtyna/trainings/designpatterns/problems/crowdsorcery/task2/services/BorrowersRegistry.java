package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task2.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task2.domain.Borrower;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BorrowersRegistry {

    private final List<Borrower> borrowers;

    public BorrowersRegistry() {
        this.borrowers = loadInitialDataFromSomeVerySlowDatabase();
    }

    public void register(Borrower borrower) {
        borrowers.add(borrower);
    }

    public void unregister(Borrower borrower) {
        borrowers.remove(borrower);
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    private List<Borrower> loadInitialDataFromSomeVerySlowDatabase() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return new ArrayList<>();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
