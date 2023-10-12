package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.services.borrowersregistry;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.solutions.patterns.SingletonPattern;

import java.util.List;
import java.util.SequencedCollection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

@SingletonPattern
public enum BorrowersRegistryEnum {

    INSTANCE;

    private final ConcurrentLinkedQueue<Borrower> borrowers;

    BorrowersRegistryEnum() {this.borrowers = loadInitialDataFromSomeVerySlowDatabase();}

    public void register(Borrower borrower) {
        borrowers.add(borrower);
    }

    public void unregister(Borrower borrower) {
        borrowers.remove(borrower);
    }

    public SequencedCollection<Borrower> getBorrowers() {
        return List.copyOf(borrowers);
    }

    private static ConcurrentLinkedQueue<Borrower> loadInitialDataFromSomeVerySlowDatabase() {
        try {
            TimeUnit.SECONDS.sleep(1);
            return new ConcurrentLinkedQueue<>();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}