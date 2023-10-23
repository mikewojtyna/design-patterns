package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task15.services.facade;

public interface BorrowerScoreFacade {

    int borrowerScore(String borrowerId);

    void updateCreditScore(int bonusPoints, String borrowerId);

}
