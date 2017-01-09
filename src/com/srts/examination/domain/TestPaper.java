package com.srts.examination.domain;

public class TestPaper {
	private long id;
	private String major;
	private String type;
	private String createdate;
	private String exam_date;//考试日期
    private String exam_time;//考试时间
    private String end_time;//结束时间
    private String exam_timeLength;//考试时长
	private String content;
	private String testPaperName;
	private String testCode;
	private TestInfo testInfo;
	public TestPaper(){}

	public TestPaper(long id, String major, String type, String createdate,
			String examDate, String examTime, String examTimeLength,
			String content, String testPaperName, String testCode,
			TestInfo testInfo) {
		this.id = id;
		this.major = major;
		this.type = type;
		this.createdate = createdate;
		exam_date = examDate;
		exam_time = examTime;
		exam_timeLength = examTimeLength;
		this.content = content;
		this.testPaperName = testPaperName;
		this.testCode = testCode;
		this.testInfo = testInfo;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String endTime) {
		end_time = endTime;
	}

	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String examDate) {
		exam_date = examDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTestPaperName() {
		return testPaperName;
	}
	public void setTestPaperName(String testPaperName) {
		this.testPaperName = testPaperName;
	}
	public TestInfo getTestInfo() {
		return testInfo;
	}
	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}
	public String getExam_time() {
		return exam_time;
	}
	public void setExam_time(String examTime) {
		exam_time = examTime;
	}
	public String getExam_timeLength() {
		return exam_timeLength;
	}
	public void setExam_timeLength(String examTimeLength) {
		exam_timeLength = examTimeLength;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}
	
	
}
