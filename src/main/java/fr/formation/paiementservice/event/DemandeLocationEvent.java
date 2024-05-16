package fr.formation.paiementservice.event;

import java.math.BigDecimal;

public class DemandeLocationEvent {

    private String userId;
    private BigDecimal prixLocation;


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPrixLocation() {
        return this.prixLocation;
    }

    public void setPrixLocation(BigDecimal prixLocation) {
        this.prixLocation = prixLocation;
    }

}
