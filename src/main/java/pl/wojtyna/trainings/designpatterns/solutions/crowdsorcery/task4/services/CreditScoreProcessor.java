package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.domain.Project;

public class CreditScoreProcessor implements ProposalProcessor {

    @Override
    public String process(Project proposal) {
        if (proposal.getCreditScore() > 100) {
            return "ACCEPTED";
        }
        return "VERIFICATION_REQUIRED";
    }
}
