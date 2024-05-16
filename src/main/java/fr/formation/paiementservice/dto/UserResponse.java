package fr.formation.paiementservice.dto;

import java.math.BigDecimal;

public class UserResponse {

	
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
