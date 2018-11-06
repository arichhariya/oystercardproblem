package com.adfg.assignment.oystercardproblem.service.impl;

import com.adfg.assignment.oystercardproblem.exceptions.CardNotValidException;
import com.adfg.assignment.oystercardproblem.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adfg.assignment.oystercardproblem.repository.CardRepository;
import com.adfg.assignment.oystercardproblem.service.IJourneyService;
import com.adfg.assignment.oystercardproblem.service.IOysterCardService;
import com.adfg.assignment.oystercardproblem.service.ServiceConstants;

@Service
public class OysterCardServiceImpl implements IOysterCardService {

    @Autowired
    IJourneyService journeyService;

    private static int CARD_COUNTER = 1;

    @Override
    public Card createCard() {
        Card card = new Card(CARD_COUNTER);
        CardRepository.cardMap.put(card.getId(), card);
        return card;
    }

    @Override
    public void addBalance(Integer cardId, Double balance) {
        Card card = CardRepository.cardMap.get(cardId);
        card.setCurrentBalance(card.getCurrentBalance() + balance);
    }

    @Override
    public void viewBalance(Card card) {
        System.out.println("*****************************************");
        System.out.println("Availaible Balance : " + card.getCurrentBalance());
        System.out.println("*****************************************");
    }

    @Override
    public Card checkIn(Integer cardId, Integer stationCode, Integer journeyType) throws CardNotValidException {
        Card card = CardRepository.cardMap.get(cardId);
        if (isCardHaveValidAmout(card))
            journeyService.initializeJourney(card, stationCode, journeyType);
        else
            throw new CardNotValidException(ServiceConstants.CARD_INVALID_MESSAGE);
        return card;
    }

    private boolean isCardHaveValidAmout(Card card) {
        return (card.getCurrentBalance() - ServiceConstants.MAX_FARE >= 0) ? true : false;

    }

    @Override
    public Card checkout(Integer cardId, Integer stationCode) {
        Card card = CardRepository.cardMap.get(cardId);
        journeyService.completeJourney(card.getJourneys().get(card.getJourneys().size() - 1), stationCode);
        card.setCurrentBalance(card.getCurrentBalance() - card.getJourneys().get(card.getJourneys().size() - 1).getFare());
        return card;
    }
}
