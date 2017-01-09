package com.srts.examination.po;

import java.util.List;

public class QuestionBankManagePo {
	private String uploadQuestionNumPerKind;
	private String uploadQuestionNumPerMonth;
	public QuestionBankManagePo(){}
	
	public QuestionBankManagePo(
			String uploadQuestionNumPerKind, String uploadQuestionNumPerMonth) {
		this.uploadQuestionNumPerKind = uploadQuestionNumPerKind;
		this.uploadQuestionNumPerMonth = uploadQuestionNumPerMonth;
	}

	public String getUploadQuestionNumPerKind() {
		return uploadQuestionNumPerKind;
	}
	public void setUploadQuestionNumPerKind(String uploadQuestionNumPerKind) {
		this.uploadQuestionNumPerKind = uploadQuestionNumPerKind;
	}
	public String getUploadQuestionNumPerMonth() {
		return uploadQuestionNumPerMonth;
	}
	public void setUploadQuestionNumPerMonth(String uploadQuestionNumPerMonth) {
		this.uploadQuestionNumPerMonth = uploadQuestionNumPerMonth;
	}
	

}
