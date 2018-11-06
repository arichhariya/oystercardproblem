package com.adfg.assignment.oystercardproblem.service.impl;

import com.adfg.assignment.oystercardproblem.model.Card;
import com.adfg.assignment.oystercardproblem.model.Journey;
import com.adfg.assignment.oystercardproblem.model.JourneyTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.adfg.assignment.oystercardproblem.repository.StationRepository;
import com.adfg.assignment.oystercardproblem.service.IFareCalculationService;
import com.adfg.assignment.oystercardproblem.service.IJourneyService;
import com.adfg.assignment.oystercardproblem.service.IOysterCardService;

@Service
public class JourneyServiceImpl implements IJourneyService {

    @Autowired
    IOysterCardService oysterCardService;

    @Autowired
    @Qualifier("BusFareService")
    IFareCalculationService busFareCalculationService;

    @Autowired
    @Qualifier("TubeFareService")
    IFareCalculationService tubeFareCalculationService;

    @Override
    public void initializeJourney(Card card, Integer stationCode, Integer journeyType) {
        Journey journey = new Journey(card.getJourneys().size() + 1, StationRepository.stationMap.get(stationCode), JourneyTypeEnum.getEnumByCode(journeyType));
        card.getJourneys().add(journey);
    }

    @Override
    public void completeJourney(Journey journey, Integer stationCode) {
        journey.setCheckOut(StationRepository.stationMap.get(stationCode));
        if (journey.getTypeEnum().getJourneyTypeName().equalsIgnoreCase(JourneyTypeEnum.BUS.getJourneyTypeName()))
            journey.setFare(busFareCalculationService.calculateFare(journey));
        else if (journey.getTypeEnum().getJourneyTypeName().equalsIgnoreCase(JourneyTypeEnum.TUBE.getJourneyTypeName()))
            journey.setFare(tubeFareCalculationService.calculateFare(journey));
    }
}
