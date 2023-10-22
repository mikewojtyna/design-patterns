package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.doman.OperationToken;

public class TransferService {

    private final PaymentGateway paymentGateway;

    public TransferService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public OperationToken transferFromInvestorToBorrower(String fromAccount, String toAccount, double amount,
                                                         String currency) {
        return paymentGateway.transfer(fromAccount, toAccount, amount, currency);
    }

}
