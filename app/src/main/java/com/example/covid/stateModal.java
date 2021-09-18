package com.example.covid;

public class stateModal {

    String cases, todCases, death, toDeath, recovered, todRecovered, stateName;

    public stateModal(String cases, String todCases, String death, String toDeath, String recovered, String todRecovered, String stateName) {
        this.cases = cases;
        this.todCases = todCases;
        this.death = death;
        this.toDeath = toDeath;
        this.recovered = recovered;
        this.todRecovered = todRecovered;
        this.stateName = stateName;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodCases() {
        return todCases;
    }

    public void setTodCases(String todCases) {
        this.todCases = todCases;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getToDeath() {
        return toDeath;
    }

    public void setToDeath(String toDeath) {
        this.toDeath = toDeath;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodRecovered() {
        return todRecovered;
    }

    public void setTodRecovered(String todRecovered) {
        this.todRecovered = todRecovered;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
