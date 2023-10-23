package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services.facade.BorrowerScoreFacade;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services.facade.RestClient;

public class BorrowerCreditScoreSyncer {

    private final RestClient restClient;
    private final BorrowerScoreFacade borrowerScoreFacade;

    public BorrowerCreditScoreSyncer(RestClient restClient, BorrowerScoreFacade borrowerScoreFacade) {
        this.restClient = restClient;
        this.borrowerScoreFacade = borrowerScoreFacade;
    }

    public void updateCreditScoreAndSyncItWithExternalService(String borrowerId) {
        borrowerScoreFacade.updateCreditScore(0, borrowerId);
        var updatedCreditScore = borrowerScoreFacade.borrowerScore(borrowerId);
        // update the external service
        var body = """
                   {
                     "id": "%s",
                     "creditScore": %d
                   }
                   """.formatted(borrowerId, updatedCreditScore);
        restClient.post("https://credit-score-service.com/credit-score", body);
    }

}
