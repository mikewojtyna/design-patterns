package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.domain.OperationStatus;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task11.domain.OperationToken;

public interface PaymentGateway {

    OperationToken transfer(String fromAccount, String toAccount, double amount, String currency);

    OperationStatus checkStatus(OperationToken token);

    void retry(OperationToken token);
}
