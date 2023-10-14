package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import jakarta.transaction.Transactional;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Project;

import java.math.RoundingMode;
import java.time.LocalDate;

public class ReturnsService {

    private final ProjectFinder projectFinder = new ProjectFinder();
    private final TransferService transferService = new TransferService();
    private DefaultHandlingService defaultHandlingService;

    @Transactional
    public void payInterests() {
        var projects = projectFinder.all();
        for (Project project : projects) {
            if (project.isProject()) {
                var repaymentSchedule = project.getRepaymentSchedule();
                if ("QUARTERLY".equals(repaymentSchedule)) {
                    if (project.getLastPaymentDate().plusMonths(3).isAfter(LocalDate.now())) {
                        var interest = project.getGoal().multipliedBy(project.getInterestRate(), RoundingMode.UP)
                                              .dividedBy(3, RoundingMode.UP);
                        for (String investorId : project.getInvestors().keySet()) {
                            transferService.transferFromBorrowerToInvestor(interest,
                                                                           investorId,
                                                                           project.getBorrower());
                        }
                    }
                }
                else if ("MONTHLY".equals(repaymentSchedule)) {
                    if (project.getLastPaymentDate().plusMonths(1).isAfter(LocalDate.now())) {
                        var interest = project.getGoal().multipliedBy(project.getInterestRate(), RoundingMode.UP)
                                              .dividedBy(12, RoundingMode.UP);
                        for (String investorId : project.getInvestors().keySet()) {
                            transferService.transferFromBorrowerToInvestor(interest,
                                                                           investorId,
                                                                           project.getBorrower());
                        }
                    }
                }
                else if ("ANNUAL".equals(repaymentSchedule)) {
                    if (project.getLastPaymentDate().plusYears(1).isAfter(LocalDate.now())) {
                        var interest = project.getGoal().multipliedBy(project.getInterestRate(), RoundingMode.UP);
                        for (String investorId : project.getInvestors().keySet()) {
                            transferService.transferFromBorrowerToInvestor(interest,
                                                                           investorId,
                                                                           project.getBorrower());
                        }
                    }
                }
            }
        }
    }
}
