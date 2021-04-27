package com.tmdp.beans;

public class BankAccount {
	private String accountNo;
	private String accounttype;
	private String bankname;
	private String ifscCode;
	public BankAccount() {
		super();
	}
	
	public BankAccount(String accountNo, String accounttype, String bankname, String ifscCode) {
		super();
		this.accountNo = accountNo;
		this.accounttype = accounttype;
		this.bankname = bankname;
		this.ifscCode = ifscCode;
	}
	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	

}
