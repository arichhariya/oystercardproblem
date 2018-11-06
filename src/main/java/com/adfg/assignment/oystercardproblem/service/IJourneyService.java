package com.adfg.assignment.oystercardproblem.service;

import com.adfg.assignment.oystercardproblem.exceptions.CardNotValidException;
import com.adfg.assignment.oystercardproblem.model.Card;
import com.adfg.assignment.oystercardproblem.model.Journey;

public interface IJourneyService {

    public void initializeJourney(Card card, Integer stationCode, Integer jorneyType) throws CardNotValidException;

    public void completeJourney(Journey journey, Integer stationCode);

}
