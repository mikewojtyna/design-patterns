package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Pending implements ProjectState {

    private final Project project;

    public Pending(Project project) {
        this.project = project;
    }

    @Override
    public void activate() {
        project.setProposal(true);
        project.setProject(false);
    }

    @Override
    public String name() {
        return "PENDING";
    }

    @Override
    public void changeState(String state) {
        if ("ACCEPTED".equals(state) && project.goal().isLessThan(Money.of(CurrencyUnit.EUR, 1_000_000))) {
            project.setState(new Accepted(project));
        }
        else if ("VERIFICATION_REQUIRED".equals(state)) {
            project.setState(new VerificationRequired(project));
        }
        else if ("REJECTED".equals(state)) {
            project.setState(new Rejected(project));
        }
        else {
            throw new IllegalArgumentException("Cannot transition from PENDING state to " + state + " state.");
        }
    }
}
