package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.annotations.StrategyPattern;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3.domain.Project;

@StrategyPattern
public class GodClassProposalProcessor implements ProposalProcessor {

    @Override
    public String process(Project proposal) {
        if ("PENDING".equals(proposal.status()) && proposal.isProposal() && proposal.getInterestRate() > 0.3) {
            return "VERIFICATION_REQUIRED";
        }
        else if (proposal.isProposal()
            && "PENDING".equals(proposal.status())
            && proposal.getCreditScore() > 100
            && proposal.getGoal().isLessThan(Money.parse("USD 100000"))
            && (proposal.description().contains("blockchain")
            || proposal.description().contains("AI"))) {
            return "ACCEPTED";
        }
        else if (proposal.isProposal() && "PENDING".equals(proposal.status()) && proposal.getCreditScore() < 100) {
            return "VERIFICATION_REQUIRED";
        }
        else if (proposal.isProposal() && "PENDING".equals(proposal.status()) && proposal.getCreditScore() > 100 &&
            proposal.getGoal().isGreaterThan(Money.parse("USD 100000"))) {
            return "VERIFICATION_REQUIRED";
        }
        else if (proposal.getGoal().isGreaterThan(Money.parse("USD 100000"))) {
            return "REJECTED";
        }
        return "NO_DECISION";
    }
}
