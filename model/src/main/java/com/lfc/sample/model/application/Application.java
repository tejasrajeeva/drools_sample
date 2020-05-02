package com.lfc.sample.model.application;

import java.util.List;
import java.util.Map;

import com.lfc.sample.model.credit.CreditReport;
import com.lfc.sample.model.credit.DebtInformation;

public class Application {

	private String name;
	private String id;
	private int age;
	
	private List<CreditReport> creditReports;
	private Map<String, DebtInformation> debtInformation;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<CreditReport> getCreditReports() {
		return creditReports;
	}
	public void setCreditReports(List<CreditReport> creditReports) {
		this.creditReports = creditReports;
	}
	public Map<String, DebtInformation> getDebtInformation() {
		return debtInformation;
	}
	public void setDebtInformation(Map<String, DebtInformation> debtInformation) {
		this.debtInformation = debtInformation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
