package com.srts.learning.po;

public class ErrorSetPo {
	private String errorSetQuestionCountByType;//questionCountByType
	private String errorSetFlagCount;// flagCount
	private String errorSetCountByFlag;//countByFlag
	public ErrorSetPo(){}
	public ErrorSetPo(String errorSetQuestionCountByType,
			String errorSetFlagCount, String errorSetCountByFlag) {
		this.errorSetQuestionCountByType = errorSetQuestionCountByType;
		this.errorSetFlagCount = errorSetFlagCount;
		this.errorSetCountByFlag = errorSetCountByFlag;
	}
	public String getErrorSetQuestionCountByType() {
		return errorSetQuestionCountByType;
	}
	public void setErrorSetQuestionCountByType(String errorSetQuestionCountByType) {
		this.errorSetQuestionCountByType = errorSetQuestionCountByType;
	}
	public String getErrorSetFlagCount() {
		return errorSetFlagCount;
	}
	public void setErrorSetFlagCount(String errorSetFlagCount) {
		this.errorSetFlagCount = errorSetFlagCount;
	}
	public String getErrorSetCountByFlag() {
		return errorSetCountByFlag;
	}
	public void setErrorSetCountByFlag(String errorSetCountByFlag) {
		this.errorSetCountByFlag = errorSetCountByFlag;
	}

}
