package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task3.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services.InvestorsRegistry;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services.TransferService;

import java.math.RoundingMode;
import java.util.Map;

public class FundraisingService {

    private InvestorsRegistry investorsRegistry;
    private pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services.TransferService transferService;
    private int processedProposals;

    public void setInvestorsRegistry(InvestorsRegistry investorsRegistry) {
        this.investorsRegistry = investorsRegistry;
    }

    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

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

    public void processProposal(Project project) {
        if (processedProposals > 1000) {
            project.setStatus("REJECTED");
            return;
        }
        if ("PENDING".equals(project.status()) && project.isProposal() && project.getInterestRate() > 0.3) {
            project.setStatus("VERIFICATION_REQUIRED");
        }
        else if (project.isProposal()
                 && "PENDING".equals(project.status())
                 && project.getCreditScore() > 100
                 && project.getGoal().isLessThan(Money.parse("USD 100000"))
                 && (project.description().contains("blockchain")
                     || project.description().contains("AI"))) {
            project.setStatus("ACCEPTED");
            project.setProposal(false);
            project.setProject(true);
        }
        else if (project.isProposal() && "PENDING".equals(project.status()) && project.getCreditScore() < 100) {
            project.setStatus("VERIFICATION_REQUIRED");
        }
        else if (project.isProposal() && "PENDING".equals(project.status()) && project.getCreditScore() > 100 &&
                 project.getGoal().isGreaterThan(Money.parse("USD 100000"))) {
            project.setStatus("VERIFICATION_REQUIRED");
        }
        else if (project.getGoal().isGreaterThan(Money.parse("USD 100000"))) {
            project.setStatus("REJECTED");
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

    public void startFundraising(Project project) {
        if ("ACCEPTED".equals(project.status())) {
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

    void releaseFundsFor(Project project) {
        if (project.status().equals("FUNDED")) {
            if ("ALL_AT_ONCE".equals(project.getLoanSchedule())) {
                for (Map.Entry<String, Money> investorEntry : project.getInvestors().entrySet()) {
                    transferService.transferFromInvestorToBorrower(investorEntry.getValue(),
                                                                   investorEntry.getKey(),
                                                                   project.getBorrower());
                }
            }
            else if ("MONTHLY".equals(project.getLoanSchedule())) {
                for (Map.Entry<String, Money> investorEntry : project.getInvestors().entrySet()) {
                    transferService.transferFromInvestorToBorrower(investorEntry.getValue()
                                                                                .dividedBy(12, RoundingMode.UP),
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
                        transferService.transferFromInvestorToBorrower(investorEntry.getValue()
                                                                                    .dividedBy(payment.getAmount(),
                                                                                               RoundingMode.UP),
                                                                       investorEntry.getKey(),
                                                                       project.getBorrower());
                    }
                }
            }
        }
    }
}
