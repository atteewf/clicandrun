package com.ateew.klikego_lite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FinalResultId implements Serializable {

    @Column(name = "event_id")
    private long event;

    @Column(name = "athlete_id")
    private long athlete;

    public FinalResultId() {}

    public FinalResultId(long event, long athlete) {
        this.event = event;
        this.athlete = athlete;
    }

    public long getEvent() { return event; }
    public void setEvent(long event) { this.event = event; }

    public long getAthlete() { return athlete; }
    public void setAthlete(long athlete) { this.athlete = athlete; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinalResultId)) return false;
        FinalResultId that = (FinalResultId) o;
        return event == that.event && athlete == that.athlete;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(event, athlete);
    }
}