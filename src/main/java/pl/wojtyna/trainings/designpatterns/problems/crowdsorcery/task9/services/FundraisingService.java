package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task9.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task9.domain.Project;

public class FundraisingService {

    private int processedProposals;

    public Project createProposalDraft(String title,
                                       String description,
                                       Money goal,
                                       String loanSchedule,
                                       double interestRate,
                                       int creditScore) {
        return new Project(title, description, goal, loanSchedule, interestRate, creditScore, "DRAFT", false);
    }

    public void proposeProject(Project project) {
        if ("DRAFT".equals(project.status())) {
            project.setStatus("PENDING");
            project.setProposal(true);
        }
    }

    public void processProposal(Project project, ProposalProcessor proposalProcessor) {
        if (processedProposals > 999) {
            project.setStatus("REJECTED");
            return;
        }
        var decision = proposalProcessor.process(project);
        if ("NO_DECISION".equals(decision)) {
            return;
        }
        project.setStatus(decision);
        if ("ACCEPTED".equals(decision)) {
            project.setProposal(false);
            project.setProject(true);
        }
        processedProposals++;
    }

    public void rejectProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("REJECTED");
        }
    }

    public void acceptProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("ACCEPTED");
            project.setProposal(false);
            project.setProject(true);
        }
    }

    public void acceptProposalForManualVerification(Project project) {
        if (project.isProposal()) {
            project.setStatus("VERIFICATION_REQUIRED");
            project.setProposal(false);
        }
    }

    public void startFundraising(Project project) {
        if ("ACCEPTED".equals(project.status()) || "VERIFICATION_REQUIRED".equals(project.status())) {
            project.setStatus("FUNDRAISING");
        }
    }

    public void depositInto(Project project, Money money, String investorId) {
        if ("FUNDRAISING".equals(project.status())) {
            project.setDeposit(project.getDeposit().plus(money));
            project.getInvestors().put(investorId, money);
            if (project.getDeposit().isGreaterThan(project.getGoal()) || project.getDeposit()
                                                                                .isEqual(project.getGoal())) {
                project.setStatus("FUNDED");
            }
        }
    }

    public void cancel(Project project) {
        if ("FUNDRAISING".equals(project.status()) || "FUNDED".equals(project.status()) || "ACCEPTED".equals(project.status())) {
            project.setStatus("CANCELLED");
        }
    }

    public void reject(Project project) {
        if ("PENDING".equals(project.status()) || "VERIFICATION_REQUIRED".equals(project.status())) {
            project.setStatus("REJECTED");
        }
    }

    public void finish(Project project) {
        if ("FUNDED".equals(project.status())) {
            project.setStatus("FINISHED");
        }
    }

    public void defaultProject(Project project) {
        if ("FUNDED".equals(project.status())) {
            project.setStatus("DEFAULT");
        }
    }

    void releaseFundsFor(Project project) {
        if ("FUNDED".equals(project.status())) {
            // release funds
        }
    }
}
