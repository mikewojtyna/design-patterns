package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.services;

import jakarta.transaction.Transactional;
import org.joda.money.Money;

public class OldTransferService {

    private final DepositService depositService = new DepositService();
    private final InvestorAndBorrowerFinder investorAndBorrowerFinder = new InvestorAndBorrowerFinder();

    @Transactional
    public void transferFromInvestorToBorrower(Money money, String fromInvestor, String toBorrower) {
        depositService.withdraw(money, investorAndBorrowerFinder.findInvestorByName(fromInvestor));
        depositService.deposit(money, investorAndBorrowerFinder.findBorrowerByName(toBorrower));
    }

}
