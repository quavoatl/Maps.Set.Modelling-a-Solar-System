package com.example;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes{
        STAR,
        PLANET,
        MOON,
    }

    public HeavenlyBody(String name, double orbitalPeriod,BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;

    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyTypes() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObj = ((HeavenlyBody) obj);
            if(this.name.equals(theObj.getName())) {
                return this.bodyType == theObj.getBodyTypes();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
