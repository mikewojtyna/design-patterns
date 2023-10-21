package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain;

import org.joda.money.Money;

import java.util.Objects;

public class Investment {

    private Money amount;
    private Project project;

    @Override
    public String toString() {
        return "Investment{" +
            "amount=" + amount +
            ", project=" + project +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Investment that = (Investment) o;
        return Objects.equals(amount, that.amount) && Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, project);
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
