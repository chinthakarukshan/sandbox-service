package com.wso2telco.services.dep.sandbox.dao.model.custom;

public class CreditRequestBean {
	
	private CreditApplyRequest creditApplyRequest;
	
	
	public CreditApplyRequest getCreditApplyRequest() {
		return creditApplyRequest;
	}


	public void setCreditApplyRequest(CreditApplyRequest creditApplyRequest) {
		this.creditApplyRequest = creditApplyRequest;
	}


	public static class CreditApplyRequest{
		
		private String type;
		
		private double amount;
		
		private String clientCorrelator;
		
		private String reasonForCredit;
		
		private String merchantIdentification;
		
		private CallbackReference receiptRequest;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getClientCorrelator() {
			return clientCorrelator;
		}

		public void setClientCorrelator(String clientCorrelator) {
			this.clientCorrelator = clientCorrelator;
		}

		public String getReasonForCredit() {
			return reasonForCredit;
		}

		public void setReasonForCredit(String reasonForCredit) {
			this.reasonForCredit = reasonForCredit;
		}

		public String getMerchantIdentification() {
			return merchantIdentification;
		}

		public void setMerchantIdentification(String merchantIdentification) {
			this.merchantIdentification = merchantIdentification;
		}

		public CallbackReference getReceiptRequest() {
			return receiptRequest;
		}

		public void setReceiptRequest(CallbackReference receiptRequest) {
			this.receiptRequest = receiptRequest;
		}
		
		
	}

}
