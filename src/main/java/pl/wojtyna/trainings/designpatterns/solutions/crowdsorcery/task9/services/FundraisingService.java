package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain.Project;

public class FundraisingService {

    public Project createProposalDraft(String title,
                                       String description,
                                       Money goal) {
        return new Project(title, description, goal);
    }

    public void proposeProject(Project project) {
        project.changeState("PENDING");
    }

    public void rejectProposal(Project project) {
        project.changeState("REJECTED");
    }

    public void accept(Project project) {
        project.changeState("ACCEPTED");
    }

    public void acceptProposalForManualVerification(Project project) {
        project.changeState("VERIFICATION_REQUIRED");
    }

    public void startFundraising(Project project) {
        project.changeState("FUNDRAISING");
    }

    public void depositInto(Project project, Money money, String investorId) {
        project.deposit(money, investorId);
    }

    public void cancel(Project project) {
        project.changeState("CANCELLED");
    }

    public void reject(Project project) {
        project.changeState("REJECTED");
    }

    public void finish(Project project) {
        project.changeState("FINISHED");
    }

    public void defaultProject(Project project) {
        project.changeState("DEFAULT");
    }
}
