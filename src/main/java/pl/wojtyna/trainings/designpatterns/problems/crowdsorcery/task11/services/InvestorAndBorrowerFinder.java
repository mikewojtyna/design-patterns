package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.services;


import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.doman.Borrower;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.doman.Investor;

public class InvestorAndBorrowerFinder {

    private final InvestorsRegistry investorsRegistry = new InvestorsRegistry();
    private final BorrowersRegistry borrowersRegistry = new BorrowersRegistry();

    public Investor findInvestorByName(String name) {
        return investorsRegistry.getInvestors().stream().filter(investor -> investor.name().equals(name)).findAny()
                                .orElseThrow();
    }

    public Borrower findBorrowerByName(String name) {
        return borrowersRegistry.getBorrowers().stream().filter(borrower -> borrower.name().equals(name)).findAny()
                                .orElseThrow();
    }
}
