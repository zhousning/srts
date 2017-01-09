package com.srts.examination.po;

import com.srts.knowledge.domain.BookChapter;

public class QuestionBankPo {
	private String id;//主键id
	private String type;//试题类型
	private String content;//试题
	private String questionPic;//题目图片
	private String answer;//答案
	private String bookChapter;//哪一章节
	private String uploadTime;//上传时间
	private String lastUpdateTime;//最后修改时间
	private String selectOptions;//选项数目
	public QuestionBankPo(){}
	public QuestionBankPo(String id, String type, String content,
			String questionPic, String answer, String bookChapter,
			String uploadTime, String lastUpdateTime, String selectOptions) {
		this.id = id;
		this.type = type;
		this.content = content;
		this.questionPic = questionPic;
		this.answer = answer;
		this.bookChapter = bookChapter;
		this.uploadTime = uploadTime;
		this.lastUpdateTime = lastUpdateTime;
		this.selectOptions = selectOptions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQuestionPic() {
		return questionPic;
	}
	public void setQuestionPic(String questionPic) {
		this.questionPic = questionPic;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getBookChapter() {
		return bookChapter;
	}
	public void setBookChapter(String bookChapter) {
		this.bookChapter = bookChapter;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getSelectOptions() {
		return selectOptions;
	}
	public void setSelectOptions(String selectOptions) {
		this.selectOptions = selectOptions;
	}
	

}
