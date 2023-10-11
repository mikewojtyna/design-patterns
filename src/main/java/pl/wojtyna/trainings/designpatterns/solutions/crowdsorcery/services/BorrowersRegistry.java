package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.Borrower;

import java.util.List;
import java.util.SequencedCollection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class BorrowersRegistry {

    private static BorrowersRegistry instance;
    private final ConcurrentLinkedQueue<Borrower> borrowers;

    private BorrowersRegistry() {
        this.borrowers = loadInitialDataFromSomeVerySlowDatabase();
    }

    public static BorrowersRegistry create() {
        if (instance != null) {
            return instance;
        }
        else {
            synchronized (BorrowersRegistry.class) {
                if (instance == null) {
                    instance = new BorrowersRegistry();
                }
                return instance;
            }
        }
    }

    public void register(Borrower borrower) {
        borrowers.add(borrower);
    }

    public void unregister(Borrower borrower) {
        borrowers.remove(borrower);
    }

    public SequencedCollection<Borrower> getBorrowers() {
        return List.copyOf(borrowers);
    }

    private ConcurrentLinkedQueue<Borrower> loadInitialDataFromSomeVerySlowDatabase() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return new ConcurrentLinkedQueue<>();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
