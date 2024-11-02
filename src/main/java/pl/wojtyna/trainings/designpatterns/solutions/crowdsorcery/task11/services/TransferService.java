package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.AdapterPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.domain.OperationStatus;

import java.util.concurrent.TimeUnit;

@AdapterPattern
public class TransferService {

    private final InvestorAndBorrowerFinder investorAndBorrowerFinder;
    private final AccountNumbers accountNumbers;
    private final PaymentGateway paymentGateway;

    public TransferService(InvestorAndBorrowerFinder investorAndBorrowerFinder, AccountNumbers accountNumbers,
                           PaymentGateway paymentGateway) {
        this.investorAndBorrowerFinder = investorAndBorrowerFinder;
        this.accountNumbers = accountNumbers;
        this.paymentGateway = paymentGateway;
    }

    public void transferFromInvestorToBorrower(Money money, String fromInvestor, String toBorrower) {
        var investor = investorAndBorrowerFinder.findInvestorByName(fromInvestor);
        var borrower = investorAndBorrowerFinder.findBorrowerByName(toBorrower);
        var investorAccountNumber = accountNumbers.findBy(investor.name());
        var borrowerAccountNumber = accountNumbers.findBy(borrower.name());
        var operationToken = paymentGateway.transfer(investorAccountNumber.value(),
                                                     borrowerAccountNumber.value(),
                                                     money.getAmount().doubleValue(),
                                                     money.getCurrencyUnit().getCode());
        for (int i = 0; i < 10; i++) {
            if (OperationStatus.PENDING.equals(paymentGateway.checkStatus(operationToken))) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException("Transfer failed", e);
                }
            }
            else {
                break;
            }
        }

        if (OperationStatus.FAILED.equals(paymentGateway.checkStatus(operationToken))) {
            for (int i = 0; i < 3; i++) {
                paymentGateway.retry(operationToken);
                if (!OperationStatus.SUCCESS.equals(paymentGateway.checkStatus(operationToken))) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException("Transfer failed", e);
                    }
                }
                else {
                    break;
                }
            }
        }
        if (!OperationStatus.SUCCESS.equals(paymentGateway.checkStatus(operationToken))) {
            throw new RuntimeException("Transfer failed");
        }
    }

}
