package com.pal.entity;

import com.pal.dto.ItineraryDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itinerary")
public class Itinerary {
    @Id
    private String itineraryId;
    private String firstDay;
    private String restOfDays;
    private String lastDay;

    public String getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(String itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }

    public String getRestOfDays() {
        return restOfDays;
    }

    public void setRestOfDays(String restOfDays) {
        this.restOfDays = restOfDays;
    }

    public String getLastDay() {
        return lastDay;
    }

    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }

    public ItineraryDTO itineraryTODto(){
        ItineraryDTO itineraryDTO=new ItineraryDTO();
        itineraryDTO.setItineraryId(this.itineraryId);
        itineraryDTO.setFirstDay(this.firstDay);
        itineraryDTO.setRestOfDays(this.restOfDays);
        itineraryDTO.setLastDay(this.lastDay);

        return itineraryDTO;
    }
}
