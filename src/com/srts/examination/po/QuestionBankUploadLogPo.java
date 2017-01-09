package com.srts.examination.po;

public class QuestionBankUploadLogPo {
	private String uploadDate;
	private String seContent;
	private String questionType;
	public QuestionBankUploadLogPo(){}
	public QuestionBankUploadLogPo(String uploadDate, String seContent,
			String questionType) {
		this.uploadDate = uploadDate;
		this.seContent = seContent;
		this.questionType = questionType;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getSeContent() {
		return seContent;
	}
	public void setSeContent(String seContent) {
		this.seContent = seContent;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	

}
