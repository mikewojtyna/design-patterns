package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain;

import lombok.Getter;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
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
    private Map<String, Money> investors;
    private List<String> milestones;
    private boolean project;
    private String repaymentSchedule;
    private LocalDate lastPaymentDate;

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

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public void setRepaymentSchedule(String repaymentSchedule) {
        this.repaymentSchedule = repaymentSchedule;
    }

    public void setProject(boolean project) {
        this.project = project;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGoal(Money goal) {
        this.goal = goal;
    }

    public void setLoanSchedule(String loanSchedule) {
        this.loanSchedule = loanSchedule;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProposal(boolean proposal) {
        this.proposal = proposal;
    }

    public void setDeposit(Money deposit) {
        this.deposit = deposit;
    }

    public void setInvestors(Map<String, Money> investors) {
        this.investors = investors;
    }

    public void setMilestones(List<String> milestones) {
        this.milestones = milestones;
    }

    public String title() {return title;}

    public String description() {return description;}

    public Money goal() {return goal;}

    public String loanSchedule() {return loanSchedule;}

    public double interestRate() {return interestRate;}

    public int creditScore() {return creditScore;}

    public String status() {return status;}

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Project) obj;
        return Objects.equals(this.title, that.title) &&
            Objects.equals(this.description, that.description) &&
            Objects.equals(this.goal, that.goal) &&
            Objects.equals(this.loanSchedule, that.loanSchedule) &&
            Double.doubleToLongBits(this.interestRate) == Double.doubleToLongBits(that.interestRate) &&
            this.creditScore == that.creditScore &&
            Objects.equals(this.status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, goal, loanSchedule, interestRate, creditScore, status);
    }

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
}
