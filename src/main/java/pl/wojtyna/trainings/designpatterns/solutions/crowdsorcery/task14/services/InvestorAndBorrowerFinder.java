package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Investor;

public class InvestorAndBorrowerFinder {

    private final InvestorsRegistry investorsRegistry = new InvestorsRegistry();
    private final BorrowersRegistry borrowersRegistry = new BorrowersRegistry();

    public Investor findByName(String name) {
        return investorsRegistry.getInvestors().stream().filter(investor -> investor.name().equals(name)).findAny()
                                .orElse(new Investor("George", "The Investor"));
    }

    public Borrower findBorrowerByName(String name) {
        return borrowersRegistry.getBorrowers().stream().filter(borrower -> borrower.name().equals(name)).findAny()
                                .orElse(new Borrower("George", "The Borrower"));
    }
}
