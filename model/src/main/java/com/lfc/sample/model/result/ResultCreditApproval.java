package com.lfc.sample.model.result;

public class ResultCreditApproval {

	private String description;
	private ApprovalReport approval = ApprovalReport.PENDING;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ApprovalReport getApproval() {
		return approval;
	}
	public void setApproval(ApprovalReport approval) {
		this.approval = approval;
	}
	
	@Override
	public String toString() {
		return "ResultCreditApproval [description=" + description + ", approval=" + approval + "]";
	}
}
