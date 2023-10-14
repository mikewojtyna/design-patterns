package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain;

import java.util.Objects;

public final class Asset {

    private final String name;
    private final String risk;

    public Asset(String name, String risk) {
        this.name = name;
        this.risk = risk;
    }

    public String name() {return name;}

    public String risk() {return risk;}

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Asset) obj;
        return Objects.equals(this.name, that.name) &&
            Objects.equals(this.risk, that.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, risk);
    }

    @Override
    public String toString() {
        return "Asset[" +
            "name=" + name + ", " +
            "risk=" + risk + ']';
    }


}
