package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.infra.adapters.secondary.paymentctxacl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.Deposit;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.PaymentProcessor;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api.PaymentGateway;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api.PaymentToken;

@Configuration
public class PaymentContextAclConfig {

    @Bean
    public PaymentProcessor paymentProcessor(DomainEventPublisher eventPublisher) {
        return new PaymentGatewayBoundedContextIntegrationProcessor(PaymentGateway.defaultGateway(),
                                                                    new PendingPayments() {
                                                                        @Override
                                                                        public void add(PaymentToken paymentToken,
                                                                                        Deposit deposit) {

                                                                        }

                                                                        @Override
                                                                        public PaymentToken getPaymentToken(Deposit deposit) {
                                                                            return null;
                                                                        }
                                                                    }, eventPublisher);
    }
}
