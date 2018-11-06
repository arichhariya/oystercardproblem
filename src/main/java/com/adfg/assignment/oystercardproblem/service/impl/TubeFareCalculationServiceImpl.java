package com.adfg.assignment.oystercardproblem.service.impl;

import com.adfg.assignment.oystercardproblem.model.Journey;
import com.adfg.assignment.oystercardproblem.model.ZoneEnum;
import org.springframework.stereotype.Service;
import com.adfg.assignment.oystercardproblem.repository.FareRepository;
import com.adfg.assignment.oystercardproblem.service.IFareCalculationService;
import com.adfg.assignment.oystercardproblem.service.ServiceConstants;

@Service("TubeFareService")
public class TubeFareCalculationServiceImpl implements IFareCalculationService {

    @Override
    public Double calculateFare(Journey journey) {
        String fareKey = createFareKey(journey);
        return FareRepository.fareMap.get(fareKey);
    }

    private String createFareKey(Journey journey) {
        StringBuilder sb = new StringBuilder();
        sb.append("COST_");
        sb.append(journey.zonesCrossed());
        if (journey.isCrossedCentralZone(ZoneEnum.valueOf(ServiceConstants.CENTRAL_ZONE_CODE))) {
            sb.append("_ZONE_INCLUDING_");
            sb.append(ServiceConstants.CENTRAL_ZONE_CODE.toUpperCase());
        } else {
            sb.append("_ZONE_EXCLUDING_");
            sb.append(ServiceConstants.CENTRAL_ZONE_CODE.toUpperCase());
        }
        return sb.toString();
    }
}
