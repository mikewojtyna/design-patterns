package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain;

import java.util.Objects;

public final class Borrower extends User {

    private int creditScore;

    public Borrower(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Borrower{" +
            "creditScore=" + creditScore +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
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
        if (!super.equals(o)) {
            return false;
        }
        Borrower borrower = (Borrower) o;
        return creditScore == borrower.creditScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditScore);
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String name() {return name;}

    public String surname() {return surname;}

}
