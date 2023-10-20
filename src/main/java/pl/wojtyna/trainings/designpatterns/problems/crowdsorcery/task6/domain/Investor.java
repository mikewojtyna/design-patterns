package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task6.domain;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.User;

import java.util.Objects;

public final class Investor extends User {

    private boolean vip;

    public Investor(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Investor{" +
            "vip=" + vip +
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
        Investor investor = (Investor) o;
        return vip == investor.vip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vip);
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String name() {return name;}

}
