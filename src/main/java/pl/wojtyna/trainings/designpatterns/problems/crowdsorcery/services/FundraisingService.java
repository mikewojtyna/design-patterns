package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Project;

import java.math.RoundingMode;
import java.util.Map;

public class FundraisingService {

    private InvestorsRegistry investorsRegistry;
    private TransferService transferService;

    public void setInvestorsRegistry(InvestorsRegistry investorsRegistry) {
        this.investorsRegistry = investorsRegistry;
    }

    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    Project createProposalDraft(String title,
                                String description,
                                Money goal,
                                String loanSchedule,
                                double interestRate,
                                int creditScore) {
        return new Project(title, description, goal, loanSchedule, interestRate, creditScore, "DRAFT", false);
    }

    void proposeProject(Project project) {
        if ("DRAFT".equals(project.status())) {
            project.setStatus("PROPOSED");
            project.setProposal(true);
        }
    }

    void processProposal(Project project) {
        if (project.isProposal()
            && project.getCreditScore() > 100
            && project.getGoal().isLessThan(Money.parse("USD 100000"))
            && (project.description().contains("blockchain")
            || project.description().contains("AI"))) {
            project.setStatus("ACCEPTED");
            project.setProposal(false);
        }
        else if (project.isProposal() && project.getCreditScore() < 100) {
            project.setStatus("VERIFICATION_REQUIRED");
        }
        else if (project.isProposal() && project.getCreditScore() > 100 && project.getGoal().isGreaterThan(Money.parse(
            "USD 100000"))) {
            project.setStatus("VERIFICATION_REQUIRED");
        }
        else if (project.getGoal().isGreaterThan(Money.parse("USD 100000"))) {
            project.setStatus("REJECTED");
        }
    }

    void rejectProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("REJECTED");
        }
    }

    void acceptProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("ACCEPTED");
        }
    }

    void startFundraising(Project project) {
        if ("ACCEPTED".equals(project.status())) {
            project.setStatus("FUNDRAISING");
        }
    }

    void depositInto(Project project, Money money, String investorId) {
        if ("FUNDRAISING".equals(project.status())) {
            project.setDeposit(project.getDeposit().plus(money));
            project.getInvestors().put(investorId, money);
            if (project.getDeposit().isGreaterThan(project.getGoal()) || project.getDeposit()
                                                                                .isEqual(project.getGoal())) {
                project.setStatus("FUNDED");
            }
        }
    }

    void releaseFundsFor(Project project) {
        if (project.status().equals("FUNDED")) {
            if ("ALL_AT_ONCE".equals(project.getLoanSchedule())) {
                for (Map.Entry<String, Money> investorEntry : project.getInvestors().entrySet()) {
                    transferService.transfer(investorEntry.getValue(), investorEntry.getKey(), project.getBorrower());
                }
            }
            else if ("MONTHLY".equals(project.getLoanSchedule())) {
                for (Map.Entry<String, Money> investorEntry : project.getInvestors().entrySet()) {
                    transferService.transfer(investorEntry.getValue().dividedBy(12, RoundingMode.UP),
                                             investorEntry.getKey(),
                                             project.getBorrower());
                }
            }
            else if ("MILESTONE".equals(project.getLoanSchedule())) {
                if (project.getMilestones().contains("FIRST") || project.getMilestones()
                                                                        .contains("SECOND") || project.getMilestones()
                                                                                                      .contains("THIRD")) {
                    for (Map.Entry<String, Money> investorEntry : project.getInvestors().entrySet()) {
                        Money payment = investorEntry.getValue().dividedBy(3, RoundingMode.UP);
                        transferService.transfer(investorEntry.getValue()
                                                              .dividedBy(payment.getAmount(), RoundingMode.UP),
                                                 investorEntry.getKey(),
                                                 project.getBorrower());
                    }
                }
            }
        }
    }
}
