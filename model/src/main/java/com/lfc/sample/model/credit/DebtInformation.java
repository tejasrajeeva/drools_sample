package com.lfc.sample.model.credit;

public class DebtInformation {

	private Double debtAmount;
	private Double debtRemaiing;
	private int interestRate;
	private String debtIssuer;
	
	public Double getDebtRemaiing() {
		return debtRemaiing;
	}
	public void setDebtRemaiing(Double debtRemaiing) {
		this.debtRemaiing = debtRemaiing;
	}
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	public String getDebtIssuer() {
		return debtIssuer;
	}
	public void setDebtIssuer(String debtIssuer) {
		this.debtIssuer = debtIssuer;
	}
	public Double getDebtAmount() {
		return debtAmount;
	}
	public void setDebtAmount(Double debtAmount) {
		this.debtAmount = debtAmount;
	}
}
