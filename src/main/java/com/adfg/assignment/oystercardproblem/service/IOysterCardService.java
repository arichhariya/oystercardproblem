package com.adfg.assignment.oystercardproblem.service;

import com.adfg.assignment.oystercardproblem.exceptions.CardNotValidException;
import com.adfg.assignment.oystercardproblem.model.Card;

public interface IOysterCardService {

    public Card createCard();

    public void addBalance(Integer cardId, Double balance);

    public void viewBalance(Card card);

    public Card checkIn(Integer cardId, Integer stationCode, Integer journeyType)throws CardNotValidException;

    public Card checkout(Integer cardId, Integer stationCode);
}
