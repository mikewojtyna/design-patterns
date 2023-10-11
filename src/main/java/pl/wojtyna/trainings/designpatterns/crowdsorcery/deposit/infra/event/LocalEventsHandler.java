package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.infra.event;

import org.springframework.context.event.EventListener;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.DepositInitiated;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.PaymentVerifiedPolicy;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.DepositInitiatedPolicy;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.PaymentVerified;

public class LocalEventsHandler {

    private final DepositInitiatedPolicy depositInitiatedPolicy;
    private final PaymentVerifiedPolicy paymentVerifiedPolicy;

    public LocalEventsHandler(DepositInitiatedPolicy depositInitiatedPolicy,
                              PaymentVerifiedPolicy paymentVerifiedPolicy) {
        this.depositInitiatedPolicy = depositInitiatedPolicy;
        this.paymentVerifiedPolicy = paymentVerifiedPolicy;
    }

    @EventListener
    public void handle(DepositInitiated depositInitiated) {
        depositInitiatedPolicy.handle(depositInitiated);
    }

    @EventListener
    public void handle(PaymentVerified paymentVerified) {
        paymentVerifiedPolicy.handle(paymentVerified);
    }
}
