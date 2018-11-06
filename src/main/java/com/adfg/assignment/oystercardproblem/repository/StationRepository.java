package com.adfg.assignment.oystercardproblem.repository;

import com.adfg.assignment.oystercardproblem.model.Station;
import com.adfg.assignment.oystercardproblem.model.ZoneEnum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StationRepository {

    public static Map<Integer, Station> stationMap = new HashMap<>();

    static {
        Set<ZoneEnum> zoneSet1 = new HashSet<>();
        zoneSet1.add(ZoneEnum.Zone_1);
        stationMap.put(1, new Station(1,"Holborn", zoneSet1));

        Set<ZoneEnum> zoneSet2 = new HashSet<>();
        zoneSet2.add(ZoneEnum.Zone_1);
        zoneSet2.add(ZoneEnum.Zone_2);
        stationMap.put(2, new Station(2,"EarlsCourt", zoneSet2));

        Set<ZoneEnum> zoneSet3 = new HashSet<>();
        zoneSet3.add(ZoneEnum.Zone_2);
        stationMap.put(3, new Station(3,"Hammersmith", zoneSet3));

        Set<ZoneEnum> zoneSet4 = new HashSet<>();
        zoneSet4.add(ZoneEnum.Zone_3);
        stationMap.put(4, new Station(4,"Wimbledon", zoneSet4));
    }


}
