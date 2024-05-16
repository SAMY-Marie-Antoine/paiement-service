package fr.formation.paiementservice.response;

import java.math.BigDecimal;

public class SoldeResponse {
	private String userId;
	private BigDecimal solde;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}




}
