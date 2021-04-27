package com.tmdp.patterns;

import com.tmdp.beans.ApplyLoanDetails;
import com.tmdp.beans.LoanApplication;

public class CropLoanManager extends LoanManager{

	@Override
	public boolean checkEligibility(ApplyLoanDetails applyLoanDetails) {
		
		return false;
	}

	@Override
	public boolean getEligibilityLoanAmount(LoanApplication loanApplication) {
		
		return false;
	}

	@Override
	public boolean issueLoanCertificate(LoanApplication loanApplication, boolean eligibilityAmount) {
		
		return false;
	}

}
