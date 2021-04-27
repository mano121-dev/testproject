package com.tmdp.patterns;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;

import com.tmdp.beans.ApplyLoanDetails;
import com.tmdp.beans.BankAccount;
import com.tmdp.beans.Identity;
import com.tmdp.beans.LoanApplication;
import com.tmdp.beans.PersonalInfo;

public abstract class LoanManager {
	public void processLoan(LoanApplication loanApplication) {
		boolean demographicInfoStatus=false;
		boolean identityStatus=false;
		boolean bankAccountStatus=false;
		boolean checkEligibility=false;
		boolean eligibilityAmount=false;
		
		demographicInfoStatus=checkDemographicinformation(loanApplication.getPersonalInfo());
		if(demographicInfoStatus==false) {
			System.out.println("ERROR: demographic verification failed");
			return;
		}
		identityStatus=verifyIdentity(loanApplication.getIdentity());
		if(identityStatus==false) {
			System.out.println("ERROR: identity mis-matched");
			return;
		}
		bankAccountStatus=verifyBankAccount(loanApplication.getBankAccount());
		if(bankAccountStatus==false) {		
			System.out.println("ERROR: bank account details are not correct");
			return;
		}
		checkEligibility=checkEligibility(loanApplication.getApplyLoanDetails());
		if(checkEligibility==false) {
			System.out.println("ERROR: does not mean loaneligiblity criteria");
			return;
		}
		eligibilityAmount=getEligibilityLoanAmount(loanApplication);
		issueLoanCertificate(loanApplication,eligibilityAmount);
	}
	
	public boolean checkDemographicinformation(PersonalInfo personalInfo) {

		if (personalInfo.getFullName() == null || personalInfo.getFullName().trim().length() == 0) {
			System.out.println("ERROR: fullname is blank");
			return false;
		}
		LocalDate localdob = LocalDate.of(personalInfo.getDob().getYear(), personalInfo.getDob().getMonth(),
				personalInfo.getDob().getDay());
		int years = Period.between(LocalDate.now(), localdob).getYears();
		if (years > 100) {
			System.out.println("ERROR:dob entered is not valid yeas:" + years);
			return false;
		}
		if (personalInfo.getGender() == null || personalInfo.getGender().trim().length() == 0) {
			System.out.println("ERROR: gender is blank");
			return false;
		}
		return true;
	}

	public boolean verifyIdentity(Identity identity) {
		if (identity.getUniqeNo() == null || identity.getUniqeNo().trim().length() == 0) {
			System.out.println("ERROR: uniqeNo is blank");
			return false;
		}
		if (identity.getIdentityType() == null || identity.getIdentityType().trim().length() == 0) {
			System.out.println("Eror:provide identity type");
			return false;
		}
		boolean flag = Arrays.asList(new String[] { "pancard", "aadhar", "voter id" }).stream()
				.anyMatch(in -> in.equals(identity.getIdentityType()));
		if (flag == false) {
			System.out.println("ERROR:not an valid identity type, please provide aadhar voter id and pancard ");
			return false;
		}
		return true;
	}
	public boolean verifyBankAccount(BankAccount account) {
		if(account.getAccountNo()==null||account.getAccountNo().trim().length()<12) {
			System.out.println("ERROR: accountno is blank");
			return false;
		}
		if(account.getAccounttype().equals("savings")==false) {
			System.out.println("ERROR:bank account is not eligible for loan disbursement");
			return false;
		}
		if(account.getIfscCode()==null||account.getIfscCode().trim().length()<8) {
			System.out.println("ERROR:invalid ifsc code");
			return false;
		}
		return true;
	}
	abstract public boolean checkEligibility(ApplyLoanDetails applyLoanDetails);
	abstract public boolean getEligibilityLoanAmount(LoanApplication loanApplication);
	abstract public boolean issueLoanCertificate(LoanApplication loanApplication,boolean eligibilityAmount);
}
