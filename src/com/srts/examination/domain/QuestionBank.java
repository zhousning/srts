package com.srts.examination.domain;

import com.srts.knowledge.domain.BookChapter;

public class QuestionBank {
	private static final long serialVersionUID = 1L;

	private long id;//主键id
	private String type;//试题类型
	private String content;//试题
	private int selectOptions;//abc选项数目或填空数目
	private String questionPic;//题目图片
	private String answer;//答案
	private BookChapter bookChapter;//哪一章节
	private String uploadTime;//上传时间
	private String lastUpdateTime;//最后修改时间
	public QuestionBank(){}
	public QuestionBank(long id, String type, String content, String questionPic, String answer,
			BookChapter bookChapter, String uploadTime, String lastUpdateTime,int selectOptions) {
		this.id = id;
		this.type = type;
		this.content = content;
		this.selectOptions = selectOptions;
		this.questionPic = questionPic;
		this.answer = answer;
		this.bookChapter = bookChapter;
		this.lastUpdateTime = lastUpdateTime;
		this.uploadTime = uploadTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public BookChapter getBookChapter() {
		return bookChapter;
	}
	public void setBookChapter(BookChapter bookChapter) {
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
	public String getQuestionPic() {
		return questionPic;
	}
	public void setQuestionPic(String questionPic) {
		this.questionPic = questionPic;
	}
	public int getSelectOptions() {
		return selectOptions;
	}
	public void setSelectOptions(int selectOptions) {
		this.selectOptions = selectOptions;
	}
}
