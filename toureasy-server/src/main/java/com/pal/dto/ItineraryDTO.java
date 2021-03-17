package com.pal.dto;

import com.pal.entity.Itinerary;

public class ItineraryDTO {
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

    public Itinerary DtoItinerary(){
        Itinerary itinerary=new Itinerary();
        itinerary.setItineraryId(this.itineraryId);
        itinerary.setFirstDay(this.firstDay);
        itinerary.setRestOfDays(this.restOfDays);
        itinerary.setLastDay(this.lastDay);

        return itinerary;
    }
}
