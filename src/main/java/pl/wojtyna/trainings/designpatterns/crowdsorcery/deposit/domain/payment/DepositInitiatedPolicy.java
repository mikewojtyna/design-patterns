package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment;

import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainPolicy;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.DepositInitiated;

public class DepositInitiatedPolicy implements DomainPolicy {

    private final PaymentProcessor paymentProcessor;

    public DepositInitiatedPolicy(PaymentProcessor paymentProcessor) {this.paymentProcessor = paymentProcessor;}

    public void handle(DepositInitiated event) {
        paymentProcessor.process(event.deposit());
    }
}
