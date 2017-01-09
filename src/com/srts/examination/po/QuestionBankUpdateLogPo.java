package com.srts.examination.po;

public class QuestionBankUpdateLogPo {
	private String updateDate;
	private String seContent;
	private String questionType;
	public QuestionBankUpdateLogPo(){}
	public QuestionBankUpdateLogPo(String updateDate, String seContent,
			String questionType) {
		this.updateDate = updateDate;
		this.seContent = seContent;
		this.questionType = questionType;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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
