package com.adfg.assignment.oystercardproblem.model;

public class Journey {

    private Integer id;
    private Station checkIn;
    private Station checkOut;
    private Double fare;
    private JourneyTypeEnum typeEnum;
    private int maxZonesCrossed;

    public Journey(Integer id, Station checkIn, JourneyTypeEnum typeEnum) {
        this.id = id;
        this.checkIn = checkIn;
        this.typeEnum = typeEnum;
        this.maxZonesCrossed = ModelConstants.MAXIMUM_ZONES_CROSSED;
    }

    public Integer getId() {
        return id;
    }

    public Station getCheckIn() {
        return checkIn;
    }

    public Station getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Station checkOut) {
        this.checkOut = checkOut;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public JourneyTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public int zonesCrossed() {
        int minZonesVisited = 0;
        if (this.checkOut != null) {
            minZonesVisited = this.maxZonesCrossed;
            for (ZoneEnum fromZone : this.checkIn.getAssociateZones()) {
                for (ZoneEnum toZone : this.checkOut.getAssociateZones()) {
                    int zonesVisited = Math.abs(fromZone.getZoneCode() - toZone.getZoneCode()) + 1;
                    if (zonesVisited < minZonesVisited) minZonesVisited = zonesVisited;
                }
            }
        }

        return minZonesVisited;
    }

    public boolean isCrossedCentralZone(ZoneEnum zone) {
        return ((this.checkIn.getAssociateZones().size() == 1 && this.checkIn.getAssociateZones().contains(zone)) || (null != this.checkOut && this.checkOut.getAssociateZones().size() == 1 && this.checkOut.getAssociateZones().contains(zone)));
    }

}
