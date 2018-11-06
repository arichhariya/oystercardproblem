package com.adfg.assignment.oystercardproblem.service.impl;

import com.adfg.assignment.oystercardproblem.model.Journey;
import org.springframework.stereotype.Service;
import com.adfg.assignment.oystercardproblem.repository.FareRepository;
import com.adfg.assignment.oystercardproblem.service.IFareCalculationService;
import com.adfg.assignment.oystercardproblem.service.ServiceConstants;

@Service("BusFareService")
public class BusFareCalculationServiceImpl implements IFareCalculationService {


    @Override
    public Double calculateFare(Journey journey) {
        return FareRepository.fareMap.get(ServiceConstants.BUS_FARE_KEY);
    }
}
