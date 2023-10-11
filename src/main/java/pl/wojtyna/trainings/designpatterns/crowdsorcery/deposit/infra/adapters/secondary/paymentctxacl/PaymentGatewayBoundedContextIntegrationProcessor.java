package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.infra.adapters.secondary.paymentctxacl;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.Deposit;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.PaymentProcessor;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.PaymentVerified;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api.PaymentEvent;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api.PaymentGateway;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api.PaymentRequest;

import java.util.concurrent.Flow;

@SecondaryAdapter
public class PaymentGatewayBoundedContextIntegrationProcessor implements PaymentProcessor {

    // this is a dependency on another bounded context
    // we keep it isolated from our domain
    private final PaymentGateway paymentGateway;
    private final PendingPayments pendingPayments;
    private final DomainEventPublisher eventPublisher;

    public PaymentGatewayBoundedContextIntegrationProcessor(PaymentGateway paymentGateway,
                                                            PendingPayments pendingPayments,
                                                            DomainEventPublisher eventPublisher) {
        this.paymentGateway = paymentGateway;
        this.pendingPayments = pendingPayments;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void process(Deposit deposit) {
        var paymentToken = paymentGateway.pay(translateToPaymentGatewayRequest(deposit));
        pendingPayments.add(paymentToken, deposit);
        translate(paymentGateway.events(pendingPayments.getPaymentToken(deposit))).subscribe(new Flow.Subscriber<>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                throw new UnsupportedOperationException("implement this");
            }

            @Override
            public void onNext(PaymentVerified item) {
                eventPublisher.publish(item);
            }

            @Override
            public void onError(Throwable throwable) {
                throw new UnsupportedOperationException("implement this");
            }

            @Override
            public void onComplete() {
                throw new UnsupportedOperationException("implement this");
            }
        });
    }

    private Flow.Publisher<PaymentVerified> translate(Flow.Publisher<PaymentEvent> events) {
        throw new UnsupportedOperationException("implement this");
    }

    private PaymentRequest translateToPaymentGatewayRequest(Deposit deposit) {
        throw new UnsupportedOperationException("implement this");
    }
}
