package com.adfg.assignment.oystercardproblem.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum JourneyTypeEnum {
    BUS (1,"BUS"), TUBE(2, "TUBE");

    private final Integer journeyTypeCode;
    private final String journeyTypeName;

    private static final Map<Integer, JourneyTypeEnum> lookup = new HashMap<>();

    static {
        for (JourneyTypeEnum j : EnumSet.allOf(JourneyTypeEnum.class))
            lookup.put(j.getJourneyTypeCode(), j);
    }

    JourneyTypeEnum(Integer journeyTypeCode, String journeyTypeName) {
        this.journeyTypeCode = journeyTypeCode;
        this.journeyTypeName = journeyTypeName;
    }

    public static JourneyTypeEnum getEnumByCode(Integer typeCode) {
        return lookup.get(typeCode);
    }

    public Integer getJourneyTypeCode() {
        return journeyTypeCode;
    }

    public String getJourneyTypeName() {
        return journeyTypeName;
    }
}
