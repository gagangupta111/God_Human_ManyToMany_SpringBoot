package com.godhuman.entity;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "humanID",
        scope     = Integer.class)
public class Human implements Serializable{

    private Integer humanID;
    private String humanName;

    private Set<God> gods = new HashSet<God>();

    public Human() {
    }

    public Human(String humanName) {
        this.humanName = humanName;
    }

    public Integer getHumanID() {
        return humanID;
    }

    public void setHumanID(Integer humanID) {
        this.humanID = humanID;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Set<God> getGods() {
        return gods;
    }

    public void setGods(Set<God> gods) {
        this.gods = gods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        return humanID != null ? humanID.equals(human.humanID) : human.humanID == null;
    }

    @Override
    public int hashCode() {
        return humanID != null ? humanID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanID=" + humanID +
                ", humanName='" + humanName + '\'' +
                ", gods=" + gods +
                '}';
    }
}
