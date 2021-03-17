package com.pal.entity;

import com.pal.dto.DetailsDTO;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {

    @Id
    private String detailsId;
    private String about;
    private String packageInclusion;
    private String highlights;
    private String pace;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITINERARY_ID")
    private Itinerary itinerary;

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPackageInclusion() {
        return packageInclusion;
    }

    public void setPackageInclusion(String packageInclusion) {
        this.packageInclusion = packageInclusion;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public String getPace() {
        return pace;
    }

    public void setPace(String pace) {
        this.pace = pace;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public DetailsDTO detailsToDto(){
        DetailsDTO detailsDTO=new DetailsDTO();

        detailsDTO.setDetailsId(this.getDetailsId());
        detailsDTO.setAbout(this.getAbout());
        detailsDTO.setHighlights(this.getHighlights());
        detailsDTO.setPace(this.getPace());
        detailsDTO.setPackageInclusion(this.getPackageInclusion());
        detailsDTO.setItineraryDTO(this.getItinerary().itineraryTODto());

        return detailsDTO;
    }

}
