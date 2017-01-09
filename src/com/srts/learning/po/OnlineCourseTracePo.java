package com.srts.learning.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习记录管理po
 * @author wyw
 *
 */
public class OnlineCourseTracePo {
	private Long usrId;
	private Long myStudyCourseId;
	private String usrName;
	private String usrCompany;
	private String usrMajor;
	private String studyCourse;
	private String studyRecoder;
	private Long studyTime;
	public OnlineCourseTracePo(){}
	public OnlineCourseTracePo(Long usrId, Long myStudyCourseId,
			String usrName, String usrCompany, String usrMajor,
			String studyCourse, String studyRecoder, Long studyTime) {
		this.usrId = usrId;
		this.myStudyCourseId = myStudyCourseId;
		this.usrName = usrName;
		this.usrCompany = usrCompany;
		this.usrMajor = usrMajor;
		this.studyCourse = studyCourse;
		this.studyRecoder = studyRecoder;
		this.studyTime = studyTime;
	}
	public Long getUsrId() {
		return usrId;
	}
	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}
	public Long getMyStudyCourseId() {
		return myStudyCourseId;
	}
	public void setMyStudyCourseId(Long myStudyCourseId) {
		this.myStudyCourseId = myStudyCourseId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrCompany() {
		return usrCompany;
	}
	public void setUsrCompany(String usrCompany) {
		this.usrCompany = usrCompany;
	}
	public String getUsrMajor() {
		return usrMajor;
	}
	public void setUsrMajor(String usrMajor) {
		this.usrMajor = usrMajor;
	}
	public String getStudyCourse() {
		return studyCourse;
	}
	public void setStudyCourse(String studyCourse) {
		this.studyCourse = studyCourse;
	}
	public String getStudyRecoder() {
		return studyRecoder;
	}
	public void setStudyRecoder(String studyRecoder) {
		this.studyRecoder = studyRecoder;
	}
	public Long getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(Long studyTime) {
		this.studyTime = studyTime;
	}
	
	public List<OnlineCourseTracePo> getCourseTracePo(List<Object[]> list){
		List<OnlineCourseTracePo> poList = new ArrayList<OnlineCourseTracePo>();
		for(Object[]objs:list){
			OnlineCourseTracePo tracePo = new OnlineCourseTracePo();
			tracePo.usrId = Long.parseLong(objs[0].toString());
			tracePo.usrName = objs[1]!=null? objs[1].toString():"";
			tracePo.usrCompany = objs[2]!=null? objs[2].toString():"";
			tracePo.usrMajor = objs[3]!=null? objs[3].toString():"";
			tracePo.myStudyCourseId = Long.parseLong(objs[4]!=null?objs[4].toString():"0");
			tracePo.studyTime =  Long.parseLong(objs[5]!=null?objs[5].toString():"");
			tracePo.studyRecoder = objs[6]!=null? objs[6].toString():"";
			tracePo.studyCourse = objs[7]!=null? objs[7].toString():"";
			poList.add(tracePo);
		}
		return poList;
	}
}
