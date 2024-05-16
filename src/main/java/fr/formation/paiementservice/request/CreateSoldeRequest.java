package fr.formation.paiementservice.request;

import java.math.BigDecimal;

public class CreateSoldeRequest {
    private BigDecimal solde;

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	
}
