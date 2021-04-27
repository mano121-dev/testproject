package com.tmdp.beans;

public class Identity {
	private String uniqeNo;
	private String identityType;
	private String issuedBy;
	public Identity() {
		super();
	}
	public Identity(String uniqeNo, String identityType, String issuedBy) {
		super();
		this.uniqeNo = uniqeNo;
		this.identityType = identityType;
		this.issuedBy = issuedBy;
	}
	public String getUniqeNo() {
		return uniqeNo;
	}
	public void setUniqeNo(String uniqeNo) {
		this.uniqeNo = uniqeNo;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	

}
