package com.adfg.assignment.oystercardproblem.model;

import java.util.HashSet;
import java.util.Set;

public class Station {

    private Integer code;
    private String Name;
    private Set<ZoneEnum> associateZones = new HashSet<>();

    public Station(Integer code, String name, Set<ZoneEnum> associateZones) {
        this.code = code;
        Name = name;
        this.associateZones = associateZones;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<ZoneEnum> getAssociateZones() {
        return associateZones;
    }

    public void setAssociateZones(Set<ZoneEnum> associateZones) {
        this.associateZones = associateZones;
    }
}
