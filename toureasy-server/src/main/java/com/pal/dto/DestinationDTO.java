package com.pal.dto;

import com.pal.entity.Destination;
import com.pal.entity.Details;

public class DestinationDTO {
    private String destinationId;
    private String continent;
    private String destinationName;
    private String imageUrl;
    private Integer noOfNights;
    private Float flightCharge;
    private Float chargePerPerson;
    private Float discount;
    private Integer availability;
    private DetailsDTO detailsDTO;

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(Integer noOfNights) {
        this.noOfNights = noOfNights;
    }

    public Float getFlightCharge() {
        return flightCharge;
    }

    public void setFlightCharge(Float flightCharge) {
        this.flightCharge = flightCharge;
    }

    public Float getChargePerPerson() {
        return chargePerPerson;
    }

    public void setChargePerPerson(Float chargePerPerson) {
        this.chargePerPerson = chargePerPerson;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public DetailsDTO getDetailsDTO() {
        return detailsDTO;
    }

    public void setDetailsDTO(DetailsDTO detailsDTO) {
        this.detailsDTO = detailsDTO;
    }

    public Destination dtoToDestination(){
        Destination destination=new Destination();

        destination.setDestinationId(this.destinationId);
        destination.setDestinationName(this.destinationName);
        destination.setAvailability(this.availability);
        destination.setContinent(this.continent);
        destination.setDiscount(this.discount);
        destination.setChargePerPerson(this.chargePerPerson);
        destination.setFlightCharge(this.flightCharge);
        destination.setImageUrl(this.imageUrl);
        destination.setNoOfNights(this.noOfNights);
        destination.setDetails(this.detailsDTO.DtoDetails());

        return destination;
    }

}
