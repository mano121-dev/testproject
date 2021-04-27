package com.tmdp.beans;

public class LoanApplication {
	private PersonalInfo personalInfo;
	private Identity identity;
	private BankAccount bankAccount;
	private ApplyLoanDetails applyLoanDetails;

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public ApplyLoanDetails getApplyLoanDetails() {
		return applyLoanDetails;
	}

	public void setApplyLoanDetails(ApplyLoanDetails applyLoanDetails) {
		this.applyLoanDetails = applyLoanDetails;
	}

}
