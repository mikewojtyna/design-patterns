package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.doman.OperationStatus;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task11.doman.OperationToken;

public interface PaymentGateway {

    OperationToken transfer(String fromAccount, String toAccount, double amount, String currency);

    OperationStatus checkStatus(OperationToken token);

    void retry(OperationToken token);
}
