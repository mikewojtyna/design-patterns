package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.domain.Project;

public class CreditScoreProcessor implements ProposalProcessor {

    @Override
    public String process(Project proposal) {
        if (proposal.getCreditScore() > 100) {
            return "ACCEPTED";
        }
        return "VERIFICATION_REQUIRED";
    }
}
