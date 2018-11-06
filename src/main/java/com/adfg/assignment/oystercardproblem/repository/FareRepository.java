package com.adfg.assignment.oystercardproblem.repository;

import java.util.HashMap;
import java.util.Map;

public class FareRepository {

    public static Map<String, Double> fareMap = new HashMap<>();

    static {
        fareMap.put("COST_1_ZONE_INCLUDING_ZONE_1", 2.50);
        fareMap.put("COST_1_ZONE_EXCLUDING_ZONE_1", 2.00);
        fareMap.put("COST_2_ZONE_INCLUDING_ZONE_1", 3.00);
        fareMap.put("COST_2_ZONE_EXCLUDING_ZONE_1", 2.25);
        fareMap.put("COST_3_ZONE_INCLUDING_ZONE_1", 3.20);
        fareMap.put("COST_3_ZONE_INCLUDING_ZONE_1", 3.20);
        fareMap.put("COST_BUS", 1.80);
    }
}
