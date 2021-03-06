package com.wso2telco.services.dep.sandbox.dao.model.custom;

public class CreditApplyResponseBean {
	
	private CreditApplyResponse creditApplyResponse;
	
	
	public CreditApplyResponse getCreditApplyResponse() {
		return creditApplyResponse;
	}


	public void setCreditApplyResponse(CreditApplyResponse creditApplyResponse) {
		this.creditApplyResponse = creditApplyResponse;
	}


	public static class CreditApplyResponse {
		
		private double amount;
		
		private String type;
		
		private String clientCorrelator;
		
		private String reasonForCredit;
		
		private String merchantIdentification;
		
		private String status;
		
		private String txnReference;

		private CallbackReference receiptResponse;

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		public String getTxnReference() {
			return txnReference;
		}

		public void setTxnReference(String txnReference) {
			this.txnReference = txnReference;
		}

		public CallbackReference getReceiptResponse() {
			return receiptResponse;
		}

		public void setReceiptResponse(CallbackReference receiptResponse) {
			this.receiptResponse = receiptResponse;
		}
		
		
	}

}