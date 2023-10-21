package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task9.domain;

import org.joda.money.Money;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Project {

    private final String title;
    private final String description;
    private final Money goal;
    private final Map<String, Money> investors;
    private boolean proposal;
    private Money deposit;
    private boolean project;
    private ProjectState state;

    public Project(String title, String description, Money goal) {
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.proposal = false;
        investors = new HashMap<>();
        setState(new Draft(this));
    }

    @Override
    public String toString() {
        return "Project{" +
               "title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", goal=" + goal +
               ", investors=" + investors +
               ", proposal=" + proposal +
               ", deposit=" + deposit +
               ", project=" + project +
               ", state=" + state +
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
        Project project1 = (Project) o;
        return proposal == project1.proposal && project == project1.project && Objects.equals(title,
                                                                                              project1.title) && Objects.equals(
            description,
            project1.description) && Objects.equals(goal, project1.goal) && Objects.equals(investors,
                                                                                           project1.investors) && Objects.equals(
            deposit,
            project1.deposit) && Objects.equals(state, project1.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, goal, investors, proposal, deposit, project, state);
    }

    public void changeState(String state) {
        System.out.printf("Changing state from %s to %s%n", this.state.name(), state);
        this.state.changeState(state);
    }

    public void deposit(Money money, String investorId) {
        deposit = deposit.plus(money);
        investors.put(investorId, money);
    }

    void setProposal(boolean flag) {
        this.proposal = flag;
    }

    void setProject(boolean flag) {
        this.project = flag;
    }

    Money goal() {
        return goal;
    }

    Money deposit() {
        return deposit;
    }

    void setState(ProjectState state) {
        this.state = state;
        this.state.activate();
    }
}
