package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import jakarta.transaction.Transactional;
import org.joda.money.Money;

public class TransferService {

    private final DepositService depositService = new DepositService();
    private final InvestorAndBorrowerFinder investorAndBorrowerFinder = new InvestorAndBorrowerFinder();

    @Transactional
    public void transferFromInvestorToBorrower(Money money, String fromInvestor, String toBorrower) {
        depositService.withdraw(money, investorAndBorrowerFinder.findByName(fromInvestor));
        depositService.deposit(money, investorAndBorrowerFinder.findBorrowerByName(toBorrower));
    }

    @Transactional
    public void transferFromBorrowerToInvestor(Money money, String toInvestor, String fromBorrower) {
        depositService.withdraw(money, investorAndBorrowerFinder.findBorrowerByName(fromBorrower));
        depositService.deposit(money, investorAndBorrowerFinder.findByName(toInvestor));
    }
}
