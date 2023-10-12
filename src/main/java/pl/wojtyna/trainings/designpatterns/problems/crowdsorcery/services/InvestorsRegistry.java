package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Investor;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class InvestorsRegistry {

    private final ConcurrentLinkedQueue<Investor> investors;

    public InvestorsRegistry() {
        this.investors = loadInitialDataFromSomeVerySlowDatabase();
    }

    public void register(Investor investor) {
        investors.add(investor);
    }

    public void unregister(Investor investor) {
        investors.remove(investor);
    }

    public List<Investor> getInvestors() {
        return List.copyOf(investors);
    }

    private ConcurrentLinkedQueue<Investor> loadInitialDataFromSomeVerySlowDatabase() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return new ConcurrentLinkedQueue<>();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
