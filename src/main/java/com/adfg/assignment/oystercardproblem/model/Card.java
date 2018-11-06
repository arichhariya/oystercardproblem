package com.adfg.assignment.oystercardproblem.model;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private Integer id;
    private Double currentBalance = 0.0;
    private List<Journey> journeys = new ArrayList<>();

    public Card(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public boolean isLastJourneyCheckedOut() {
        return (this.journeys.size() == 0 || (this.journeys.size() > 0 && this.journeys.get(this.journeys.size()-1).getCheckOut() != null)) ? true : false;
    }
}
