package com.srts.estimation.po;

public class UserInfoPo {
	private String id;
	private String userUsedTimeLength;
	private String aveStudyTimeLength;
	private String type;
	private String course;
	public UserInfoPo(){}
	public UserInfoPo(String id, String userUsedTimeLength,
			String aveStudyTimeLength, String type, String course) {
		this.id = id;
		this.userUsedTimeLength = userUsedTimeLength;
		this.aveStudyTimeLength = aveStudyTimeLength;
		this.type = type;
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserUsedTimeLength() {
		return userUsedTimeLength;
	}
	public void setUserUsedTimeLength(String userUsedTimeLength) {
		this.userUsedTimeLength = userUsedTimeLength;
	}
	public String getAveStudyTimeLength() {
		return aveStudyTimeLength;
	}
	public void setAveStudyTimeLength(String aveStudyTimeLength) {
		this.aveStudyTimeLength = aveStudyTimeLength;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	

}
