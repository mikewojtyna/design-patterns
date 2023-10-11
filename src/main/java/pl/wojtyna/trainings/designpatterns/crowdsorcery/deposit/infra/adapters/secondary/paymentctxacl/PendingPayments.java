package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.infra.adapters.secondary.paymentctxacl;

import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.Deposit;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.payment.api.PaymentToken;

public interface PendingPayments {

    void add(PaymentToken paymentToken, Deposit deposit);

    PaymentToken getPaymentToken(Deposit deposit);
}
