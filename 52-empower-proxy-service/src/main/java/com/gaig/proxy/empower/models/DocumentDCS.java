package com.gaig.proxy.empower.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentDCS {

	String claimNumber;
	String	sendTo;
	String	toAddressLine1;
	String toState;
	String toZip;
	String	reportedDate;
	String	policyTerm;
	String policyNumber;
	String policyExp;
	String	claimantSignature;
	String	docuName;
	String	claimantFullName;

	public DocumentDCS() {
		
	}

	public DocumentDCS(String claimNumber, String sendTo, String toAddressLine1, String toState, String toZip,
			String reportedDate, String policyTerm, String policyNumber, String policyExp, String claimantSignature,
			String docuName, String claimantFullName) {
		super();
		this.claimNumber = claimNumber;
		this.sendTo = sendTo;
		this.toAddressLine1 = toAddressLine1;
		this.toState = toState;
		this.toZip = toZip;
		this.reportedDate = reportedDate;
		this.policyTerm = policyTerm;
		this.policyNumber = policyNumber;
		this.policyExp = policyExp;
		this.claimantSignature = claimantSignature;
		this.docuName = docuName;
		this.claimantFullName = claimantFullName;
	}

	public String getclaimNumber() {
		return claimNumber;
	}

	@JsonProperty("ClaimNumber")
	public void setclaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getsendTo() {
		return sendTo;
	}

	@JsonProperty("SendTo")
	public void setsendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String gettoAddressLine1() {
		return toAddressLine1;
	}

	@JsonProperty("ToAddressLine1")
	public void settoAddressLine1(String toAddressLine1) {
		this.toAddressLine1 = toAddressLine1;
	}

	public String gettoState() {
		return toState;
	}

	@JsonProperty("ToState")
	public void settoState(String toState) {
		this.toState = toState;
	}

	public String gettoZip() {
		return toZip;
	}
	@JsonProperty("ToZip")
	public void settoZip(String toZip) {
		this.toZip = toZip;
	}

	public String getreportedDate() {
		return reportedDate;
	}
	@JsonProperty("ReportedDate")
	public void setreportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getpolicyTerm() {
		return policyTerm;
	}
	@JsonProperty("PolicyTerm")
	public void setpolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getpolicyNumber() {
		return policyNumber;
	}
	@JsonProperty("PolicyNumber")
	public void setpolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getpolicyExp() {
		return policyExp;
	}
	@JsonProperty("PolicyExp")
	public void setpolicyExp(String policyExp) {
		this.policyExp = policyExp;
	}

	public String getclaimantSignature() {
		return claimantSignature;
	}
	@JsonProperty("ClaimantSignature")
	public void setclaimantSignature(String claimantSignature) {
		this.claimantSignature = claimantSignature;
	}

	public String getdocuName() {
		return docuName;
	}
	@JsonProperty("DocuName")
	public void setdocuName(String docuName) {
		this.docuName = docuName;
	}

	public String getclaimantFullName() {
		return claimantFullName;
	}

	@JsonProperty("ClaimantFullName")
	public void setclaimantFullName(String claimantFullName) {
		this.claimantFullName = claimantFullName;
	}

	public String concatvalues() {
		return 
		 claimNumber+"|"
		+	sendTo+"|"
		+	toAddressLine1+"|"
		+ 	toState+"|"
		+ 	toZip+"|"
		+	reportedDate+"|"
		+	policyTerm+"|"
		+ 	policyNumber+"|"
		+ 	policyExp+"|"
		+	claimantSignature+"|"
		+	docuName+"|"
		+	claimantFullName;
				
				
				
		}
	
	
	@Override
	public String toString() {
		return "DocumentDCS [claimNumber=" + claimNumber + ", sendTo=" + sendTo + ", toAddressLine1=" + toAddressLine1
				+ ", toState=" + toState + ", toZip=" + toZip + ", reportedDate=" + reportedDate + ", policyTerm="
				+ policyTerm + ", policyNumber=" + policyNumber + ", policyExp=" + policyExp + ", claimantSignature="
				+ claimantSignature + ", docuName=" + docuName + ", claimantFullName=" + claimantFullName + "]";
	}

}