package com.gaig.poc.documentcreation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProxyDocument {	
	
	String claimNumber;
	String sendTo;
	String toAddressLine1;
	String toState;
	String toZip;
	String reportedDate;
	String policyTerm;
	String policyNumber;
	String policyExp;
	String claimantSignature;
	String docuName;
	String claimantFullName;
	
	public String getClaimNumber() {
		return claimNumber;
	}
	@JsonProperty("ClaimNumber")
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getSendTo() {
		return sendTo;
	}
	@JsonProperty("SendTo")
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getToAddressLine1() {
		return toAddressLine1;
	}
	@JsonProperty("ToAddressLine1")
	public void setToAddressLine1(String toAddressLine1) {
		this.toAddressLine1 = toAddressLine1;
	}
	public String getToState() {
		return toState;
	}
	@JsonProperty("ToState")
	public void setToState(String toState) {
		this.toState = toState;
	}
	public String getToZip() {
		return toZip;
	}
	@JsonProperty("ToZip")
	public void setToZip(String toZip) {
		this.toZip = toZip;
	}
	public String getReportedDate() {
		return reportedDate;
	}
	@JsonProperty("ReportedDate")
	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}
	public String getPolicyTerm() {
		return policyTerm;
	}
	@JsonProperty("PolicyTerm")
	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	@JsonProperty("PolicyNumber")
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyExp() {
		return policyExp;
	}
	@JsonProperty("PolicyExp")
	public void setPolicyExp(String policyExp) {
		this.policyExp = policyExp;
	}
	public String getClaimantSignature() {
		return claimantSignature;
	}
	@JsonProperty("ClaimantSignature")
	public void setClaimantSignature(String claimantSignature) {
		this.claimantSignature = claimantSignature;
	}
	public String getDocuName() {
		return docuName;
	}
	@JsonProperty("DocuName")
	public void setDocuName(String docuName) {
		this.docuName = docuName;
	}
	public String getClaimantFullName() {
		return claimantFullName;
	}
	@JsonProperty("ClaimantFullName")
	public void setClaimantFullName(String claimantFullName) {
		this.claimantFullName = claimantFullName;
	}
	
	@Override
	public String toString() {
		return "ProxyDocument [claimNumber=" + claimNumber + ", sendTo=" + sendTo + ", toAddressLine1=" + toAddressLine1
				+ ", toState=" + toState + ", toZip=" + toZip + ", reportedDate=" + reportedDate + ", policyTerm="
				+ policyTerm + ", policyNumber=" + policyNumber + ", policyExp=" + policyExp + ", claimantSignature="
				+ claimantSignature + ", docuName=" + docuName + ", claimantFullName=" + claimantFullName + "]";
	}		

}
