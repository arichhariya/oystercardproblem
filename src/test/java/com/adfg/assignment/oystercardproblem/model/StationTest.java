package com.adfg.assignment.oystercardproblem.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StationTest {

    private static final Integer STAION_ID = 123;
    private static final String STATION_NAME = "XYZ";
    private Station station;

    @Before
    public void setup() {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        station = new Station(STAION_ID,STATION_NAME, zoneSet1);
    }

    @Test
    public void constructor_shouldSetInitialValuesBasedOnParams() {
        assertEquals(STAION_ID, station.getCode());
        assertEquals(STATION_NAME,station.getName());
        assertNotNull(station.getAssociateZones());
    }

}
