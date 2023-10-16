package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.services;

import pl.wojtyna.trainings.designpatterns.annotations.SingletonPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.domain.Investor;

import java.util.List;
import java.util.SequencedCollection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

@SingletonPattern
public class InvestorRegistry {

    private static volatile InvestorRegistry instance;
    private final ConcurrentLinkedQueue<Investor> investors;

    private InvestorRegistry() {
        this.investors = loadInitialDataFromSomeVerySlowDatabase();
    }

    public static InvestorRegistry create() {
        if (instance != null) {
            return instance;
        }
        else {
            synchronized (InvestorRegistry.class) {
                if (instance == null) {
                    instance = new InvestorRegistry();
                }
                return instance;
            }
        }
    }

    public void register(Investor investor) {
        investors.add(investor);
    }

    public void unregister(Investor investor) {
        investors.remove(investor);
    }

    public SequencedCollection<Investor> getInvestors() {
        return List.copyOf(investors);
    }

    private ConcurrentLinkedQueue<Investor> loadInitialDataFromSomeVerySlowDatabase() {
        try {
            TimeUnit.SECONDS.sleep(1);
            return new ConcurrentLinkedQueue<>();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
