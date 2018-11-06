package com.adfg.assignment.oystercardproblem.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private static final Integer CARD_ID = 123;

    private Card card;
    private static final Double BALANCE = 30.0D;
    private static final Integer JOURNEY_ID = 123;

    @Before
    public void setup() {
        card = new Card(CARD_ID);
        card.setCurrentBalance(BALANCE);

    }

    @Test
    public void constructor_shouldSetInitialValuesBasedOnParams() {
        assertEquals(CARD_ID, card.getId());
    }

    @Test
    public void isLastJourneyCheckedOut_shouldReturnTrueForNoJourney() {
        assertEquals(true, card.isLastJourneyCheckedOut());
    }

    @Test
    public void isLastJourneyCheckedOut_shouldReturnFalseForJourneyWithoutCheckedOutStation() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        Station station = new Station(1, "Holborn", zoneSet1);
        Journey journey = new Journey(JOURNEY_ID, station, JourneyTypeEnum.TUBE);
        card.getJourneys().add(journey);
        assertEquals(false, card.isLastJourneyCheckedOut());
    }
    @Test
    public void isLastJourneyCheckedOut_shouldReturnTrueForJourneyWithCheckedOutStation() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        Station station = new Station(1, "Holborn", zoneSet1);
        Journey journey = new Journey(JOURNEY_ID, station, JourneyTypeEnum.TUBE);
        card.getJourneys().add(journey);
        card.getJourneys().get(0).setCheckOut(station);
        assertEquals(true, card.isLastJourneyCheckedOut());
    }
}
