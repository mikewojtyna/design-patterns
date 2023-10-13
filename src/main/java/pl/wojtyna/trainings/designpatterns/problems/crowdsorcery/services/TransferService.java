package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import jakarta.transaction.Transactional;
import org.joda.money.Money;

public class TransferService {

    private final DepositService depositService;
    private final InvestorFinder investorFinder;

    public TransferService(DepositService depositService, InvestorFinder investorFinder) {
        this.depositService = depositService;
        this.investorFinder = investorFinder;
    }

    @Transactional
    public void transfer(Money money, String fromInvestor, String toBorrower) {
        depositService.withdraw(money, investorFinder.findByName(fromInvestor));
        depositService.deposit(money, investorFinder.findByName(toBorrower));
    }
}
