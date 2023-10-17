package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.domain.Project;

public class GoalProcessor implements ProposalProcessor {

    @Override
    public String process(Project proposal) {
        if (proposal.getGoal().isLessThan(Money.parse("USD 100000"))) {
            return "ACCEPTED";
        }
        return "REJECTED";
    }
}
