package com.pal.dto;

import com.pal.entity.Details;
import com.pal.entity.Itinerary;

public class DetailsDTO {
    private String detailsId;
    private String about;
    private String packageInclusion;
    private String highlights;
    private String pace;
    private ItineraryDTO itineraryDTO;

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

    public ItineraryDTO getItineraryDTO() {
        return itineraryDTO;
    }

    public void setItineraryDTO(ItineraryDTO itineraryDTO) {
        this.itineraryDTO = itineraryDTO;
    }

    public Details DtoDetails(){
        Details details=new Details();

        details.setDetailsId(this.detailsId);
        details.setAbout(this.about);
        details.setHighlights(this.highlights);
        details.setPace(this.pace);
        details.setPackageInclusion(this.packageInclusion);
        details.setItinerary(this.itineraryDTO.DtoItinerary());

        return details;
    }
}
