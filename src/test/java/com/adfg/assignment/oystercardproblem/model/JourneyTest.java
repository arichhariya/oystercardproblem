package com.adfg.assignment.oystercardproblem.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JourneyTest {

    private static final Integer JOURNEY_ID = 123;
    private static final Integer STATION_ID = 1;
    private static final String STATION_NAME = "Holborn";

    private Journey journey;

    @Before
    public void setup() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        Station station = new Station(STATION_ID, STATION_NAME, zoneSet1);
        journey = new Journey(JOURNEY_ID, station, JourneyTypeEnum.TUBE);
    }

    @Test
    public void constructor_shouldSetInitialValuesBasedOnParams() {
        assertEquals(JOURNEY_ID, journey.getId());
        assertNotNull(journey.getCheckIn());
        assertEquals(JourneyTypeEnum.TUBE,journey.getTypeEnum());
    }

    @Test
    public void zonesCrossed_shouldReturnZeroIfNoCheckoutStation() {
        assertEquals(0, journey.zonesCrossed());

    }

    @Test
    public void zonesCrossed_shouldReturnOneIfCheckoutStationIsInSameZone() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        Station station = new Station(123, "xyz", zoneSet1);
        journey.setCheckOut(station);
        assertEquals(1, journey.zonesCrossed());

    }

    @Test
    public void zonesCrossed_shouldReturnOneIfCheckoutStationHasMultipleZoneAndHavingCommonCheckedinZone() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        zoneSet1.add(ZoneEnum.Zone_2);
        Station station = new Station(123, "xyz", zoneSet1);
        journey.setCheckOut(station);
        assertEquals(1, journey.zonesCrossed());

    }

    @Test
    public void zonesCrossed_shouldReturnExpectedValueIfCheckoutStationInAnotherZone() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_2);
        Station station = new Station(123, "xyz", zoneSet1);
        journey.setCheckOut(station);
        assertEquals(2, journey.zonesCrossed());

    }

    @Test
    public void isCrossedCentralZone_shouldReturnTrueForPassingZone1AsCetralZone(){
        assertEquals(true, journey.isCrossedCentralZone(ZoneEnum.Zone_1));
    }

    @Test
    public void isCrossedCentralZone_shouldReturnTrueForPassingZone2AsCetralZone(){
        assertEquals(false, journey.isCrossedCentralZone(ZoneEnum.Zone_2));
    }

    @Test
    public void isCrossedCentralZone_shouldReturnTrueForPassingNullAsCetralZone(){
        assertEquals(false, journey.isCrossedCentralZone(null));
    }
}
