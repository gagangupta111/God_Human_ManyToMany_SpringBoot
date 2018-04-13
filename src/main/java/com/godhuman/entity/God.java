package com.godhuman.entity;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "godID",
        scope     = Integer.class)
public class God implements Serializable{

    private Integer godID;
    private String godName;

    private Set<Human> humans = new HashSet<Human>();

    public God() {
    }

    public God(String godName) {
        this.godName = godName;
    }

    public Integer getGodID() {
        return godID;
    }

    public void setGodID(Integer godID) {
        this.godID = godID;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public Set<Human> getHumans() {
        return humans;
    }

    public void setHumans(Set<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        God god = (God) o;

        return godID != null ? godID.equals(god.godID) : god.godID == null;
    }

    @Override
    public int hashCode() {
        return godID != null ? godID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "God{" +
                "godID=" + godID +
                ", godName='" + godName + '\'' +
                ", humans=" + humans +
                '}';
    }
}
