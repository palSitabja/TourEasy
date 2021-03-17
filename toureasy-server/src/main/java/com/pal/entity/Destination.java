package com.pal.entity;

import com.pal.dto.DestinationDTO;
import com.pal.dto.DetailsDTO;

import javax.persistence.*;

@Entity
@Table(name = "destination")
public class Destination {
    @Id
    private String destinationId;

    private String continent;
    private String destinationName;
    private String imageUrl;
    private Integer noOfNights;
    private Float flightCharge;
    private Float chargePerPerson;
    private Float discount;

    @Version
    private Long version;

    private Integer availability;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID")
    private Details details;

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public DestinationDTO destinationToDTo(){
        DestinationDTO destinationDTO=new DestinationDTO();
        destinationDTO.setDestinationId(this.destinationId);
        destinationDTO.setDestinationName(this.destinationName);
        destinationDTO.setAvailability(this.availability);
        destinationDTO.setContinent(this.continent);
        destinationDTO.setDiscount(this.discount);
        destinationDTO.setChargePerPerson(this.chargePerPerson);
        destinationDTO.setFlightCharge(this.flightCharge);
        destinationDTO.setImageUrl(this.imageUrl);
        destinationDTO.setNoOfNights(this.noOfNights);
        destinationDTO.setDetailsDTO(this.details.detailsToDto());

        return destinationDTO;
    }

}
