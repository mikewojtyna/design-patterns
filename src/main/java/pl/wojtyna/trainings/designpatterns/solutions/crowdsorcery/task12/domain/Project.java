package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class Project {

    private String borrower;
    private String title;
    private String description;
    private Money goal;
    private String loanSchedule;
    private double interestRate;
    private int creditScore;
    private String status;
    private boolean proposal;
    private Money deposit;
    @ElementCollection
    private Map<String, Money> investors;
    @ElementCollection
    private List<String> milestones;
    private boolean project;
    private String repaymentSchedule;
    private LocalDate lastPaymentDate;
    @Id
    private Long id;

    public Project(String title, String description, Money goal, String loanSchedule,
                   double interestRate, int creditScore, String status, boolean proposal) {
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.loanSchedule = loanSchedule;
        this.interestRate = interestRate;
        this.creditScore = creditScore;
        this.status = status;
        this.proposal = proposal;
    }

    public Project() {

    }

    public String title() {return title;}

    public String description() {return description;}

    public Money goal() {return goal;}

    public String loanSchedule() {return loanSchedule;}

    public double interestRate() {return interestRate;}

    public int creditScore() {return creditScore;}

    public String status() {return status;}

    @Override
    public String toString() {
        return "Project[" +
               "title=" + title + ", " +
               "description=" + description + ", " +
               "goal=" + goal + ", " +
               "loanSchedule=" + loanSchedule + ", " +
               "interestRate=" + interestRate + ", " +
               "creditScore=" + creditScore + ", " +
               "status=" + status + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project1 = (Project) o;
        return Double.compare(interestRate,
                              project1.interestRate) == 0 && creditScore == project1.creditScore && proposal == project1.proposal && project == project1.project && Objects.equals(
            borrower,
            project1.borrower) && Objects.equals(title, project1.title) && Objects.equals(description,
                                                                                          project1.description) && Objects.equals(
            goal,
            project1.goal) && Objects.equals(loanSchedule, project1.loanSchedule) && Objects.equals(
            status,
            project1.status) && Objects.equals(deposit, project1.deposit) && Objects.equals(investors,
                                                                                            project1.investors) && Objects.equals(
            milestones,
            project1.milestones) && Objects.equals(repaymentSchedule,
                                                   project1.repaymentSchedule) && Objects.equals(
            lastPaymentDate,
            project1.lastPaymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrower,
                            title,
                            description,
                            goal,
                            loanSchedule,
                            interestRate,
                            creditScore,
                            status,
                            proposal,
                            deposit,
                            investors,
                            milestones,
                            project,
                            repaymentSchedule,
                            lastPaymentDate);
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getGoal() {
        return goal;
    }

    public void setGoal(Money goal) {
        this.goal = goal;
    }

    public String getLoanSchedule() {
        return loanSchedule;
    }

    public void setLoanSchedule(String loanSchedule) {
        this.loanSchedule = loanSchedule;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isProposal() {
        return proposal;
    }

    public void setProposal(boolean proposal) {
        this.proposal = proposal;
    }

    public Money getDeposit() {
        return deposit;
    }

    public void setDeposit(Money deposit) {
        this.deposit = deposit;
    }

    public Map<String, Money> getInvestors() {
        return investors;
    }

    public void setInvestors(Map<String, Money> investors) {
        this.investors = investors;
    }

    public List<String> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<String> milestones) {
        this.milestones = milestones;
    }

    public boolean isProject() {
        return project;
    }

    public void setProject(boolean project) {
        this.project = project;
    }

    public String getRepaymentSchedule() {
        return repaymentSchedule;
    }

    public void setRepaymentSchedule(String repaymentSchedule) {
        this.repaymentSchedule = repaymentSchedule;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
