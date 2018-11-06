package com.adfg.assignment.oystercardproblem.model;

public enum ZoneEnum {
    Zone_1(1, "ZONE_1"), Zone_2(2, "ZONE_2"), Zone_3(3, "ZONE_3"),
    Zone_4(4, "ZONE_4"), Zone_5(5, "ZONE_5"), Zone_6(2, "ZONE_6");

    private final Integer zoneCode;
    private final String zoneName;

    ZoneEnum(Integer zoneCode, String zoneName) {
        this.zoneCode = zoneCode;
        this.zoneName = zoneName;
    }

    public Integer getZoneCode() {
        return zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }
}
