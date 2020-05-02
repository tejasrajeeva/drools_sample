package com.lfc.sample.model.credit;

public class CreditReport {

	private String bureauId;
	private int creditScore;
	private double currentDebt;
	private VerificationStatus verificationStatus;
	
	public String getBureauId() {
		return bureauId;
	}
	public void setBureauId(String bureauId) {
		this.bureauId = bureauId;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public double getCurrentDebt() {
		return currentDebt;
	}
	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
	}
	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}
	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	
}
