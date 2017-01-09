package com.srts.learning.po;

import com.srts.examination.domain.QuestionBank;
import com.srts.system.domain.Sys_User;

/**
 * 
 * @author H 2014-5-24 下午03:12:03
 *本类的作用是：收集前台传回的用户做题情况，判断每道题对错，整理准确率等数据，更新错题集表/错题集flag表/在线练习统计表
 */
public class ExerciseJudgeAnswerPo {
	private String answer;
	private int resultStatus;
	private QuestionBank questionResult;
	public ExerciseJudgeAnswerPo() {
	}
	public ExerciseJudgeAnswerPo(String answer, int resultStatus,
			QuestionBank questionResult) {
		this.answer = answer;
		this.resultStatus = resultStatus;
		this.questionResult = questionResult;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	public QuestionBank getQuestionResult() {
		return questionResult;
	}
	public void setQuestionResult(QuestionBank questionResult) {
		this.questionResult = questionResult;
	}
	
}
