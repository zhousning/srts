package com.srts.controlPanel.service;

import java.text.ParseException;
import java.util.List;

import com.srts.controlPanel.po.FavorCourseInfoPo;
import com.srts.controlPanel.po.FavorKlgBankInfoPo;
import com.srts.controlPanel.po.FavorThemeInfoPo;
import com.srts.controlPanel.po.MyAnswerInfoPo;
import com.srts.controlPanel.po.MyCompetitionInfoPo;
import com.srts.controlPanel.po.MyCourseInfoPo;
import com.srts.controlPanel.po.MyEstInfoPo;
import com.srts.controlPanel.po.MyExerciseInfoPo;
import com.srts.controlPanel.po.MyKlgUploadInfoPo;
import com.srts.controlPanel.po.MyNoticeInfoPo;
import com.srts.controlPanel.po.MyProblemInfoPo;
import com.srts.controlPanel.po.MyTestInfoPo;
import com.srts.controlPanel.po.MyThemeInfoPo;
import com.srts.system.domain.Sys_User;

public interface PersonalInfoListService {
	public List<MyNoticeInfoPo> selectNoticeByUser(Sys_User usr);
	public List<MyTestInfoPo> selectTrainTestInfoByUser(Sys_User usr);
	public List<MyTestInfoPo> selectMockTestInfoByUser(Sys_User usr);
	public List<MyCompetitionInfoPo> selectCompetitionInfoByUser(Sys_User usr);
	public List<MyCourseInfoPo> selectCourseInfoByUser(Sys_User usr);
	public List<FavorCourseInfoPo> selectFavorCourse();
	public List<MyExerciseInfoPo> selectExerciseInfoByUser(Sys_User usr);
	public List<MyKlgUploadInfoPo> selectKlgBankInfoByUser(Sys_User usr);
	public List<FavorKlgBankInfoPo> selectFavorKlgBank();
	public List<MyProblemInfoPo> selectProblemInfoByUser(Sys_User usr);
	public List<MyAnswerInfoPo> selectAnswerInfoByUser(Sys_User usr);
	public List<MyThemeInfoPo> selectThemeByUser(Sys_User usr);
	public List<FavorThemeInfoPo> selectFavorThemeByUser();
	public MyEstInfoPo setEstInfo(Sys_User usr) throws ParseException;

}
