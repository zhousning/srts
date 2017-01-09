package com.srts.communication.domain;

import java.util.Date;


/**
 * 问题追问回复
 * @author wyw
 */
public class AnswerAsk {
	private long id;// 主键
	private String askContent;// 追问内容
	private Date askDate;// 追问日期
	private String askDateStr;
	private String answerContent;// 回复追问
	private Date answerDate;// 回复日期
	private String answerDateStr;
	private AnswerInfo answer;// 哪次回复的追问

	public AnswerAsk() {
	}

	public AnswerAsk(long id, String askContent, Date askDate,
			String answerContent, Date answerDate, AnswerInfo answer) {
		this.id = id;
		this.askContent = askContent;
		this.askDate = askDate;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.answer = answer;
	}
	
	public String getAskDateStr() {
		return askDateStr;
	}

	public void setAskDateStr(String askDateStr) {
		this.askDateStr = askDateStr;
	}

	public String getAnswerDateStr() {
		return answerDateStr;
	}

	public void setAnswerDateStr(String answerDateStr) {
		this.answerDateStr = answerDateStr;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAskContent() {
		return askContent;
	}

	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}

	public Date getAskDate() {
		return askDate;
	}

	public void setAskDate(Date date) {
		this.askDate = date;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public AnswerInfo getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerInfo answer) {
		this.answer = answer;
	}
}
