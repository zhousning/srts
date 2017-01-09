package com.srts.estimation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.WorkerOnlineExerciseEstDao;
import com.srts.estimation.dao.WorkerOnlineStudyEstDao;
import com.srts.estimation.po.UserExeAcurInfoPo;
import com.srts.estimation.po.UserExeEstimatePo;
import com.srts.estimation.po.UserExeFeqInfoPo;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;

@Service
public class WorkerOnlineExerciseEstServiceImpl implements
		WorkerOnlineExerciseEstService {
	
	@Resource
	private WorkerOnlineExerciseEstDao workerOnlineExerciseEstDao;
	@Resource
	private ErrorSetDao errorSetDao;
	@Resource
	private Sys_UserDao sys_UserDao;

	public List<UserExeFeqInfoPo> setUserExerciseFrequencyInfo(Sys_User usr) {
		List<String[]> resList0=workerOnlineExerciseEstDao.selectExerciseFeqByUserToday(usr);
		List<String[]> resList1=workerOnlineExerciseEstDao.selectExerciseFeqByUserToWeek(usr);
		List<String[]> resList2=workerOnlineExerciseEstDao.selectExerciseFeqByUserToMonth(usr);
		List<UserExeFeqInfoPo> res=new ArrayList<UserExeFeqInfoPo>();
		int size0=resList0.size();
		int size1=resList1.size();
		int size2=resList2.size();
		for(int i=0;i<resList0.size();i++)
		{
			UserExeFeqInfoPo temp=new UserExeFeqInfoPo();
			String id=String.valueOf(i+1);
			String time=resList0.get(i)[1];
			String exerciseFeq=resList0.get(i)[0];
			String aveExerciseQuestionNum=resList0.get(i)[2];
			temp.setId(id);
			temp.setTime(time);
			temp.setAveExerciseQuestionNum(aveExerciseQuestionNum);
			temp.setExerciseFeq(exerciseFeq);
			res.add(temp);
		}
		for(int j=0;j<resList1.size();j++)
		{
			UserExeFeqInfoPo temp=new UserExeFeqInfoPo();
			String id=String.valueOf(j+size0);
			String time=resList1.get(j)[1];
			String exerciseFeq=resList1.get(j)[0];
			String aveExerciseQuestionNum=resList1.get(j)[2];
			temp.setId(id);
			temp.setTime(time);
			temp.setAveExerciseQuestionNum(aveExerciseQuestionNum);
			temp.setExerciseFeq(exerciseFeq);
			res.add(temp);
		}
		for(int k=0;k<resList2.size();k++)
		{
			UserExeFeqInfoPo temp=new UserExeFeqInfoPo();
			String id=String.valueOf(k+size0+size1);
			String time=resList2.get(k)[1];
			String exerciseFeq=resList2.get(k)[0];
			String aveExerciseQuestionNum=resList2.get(k)[2];
			temp.setId(id);
			temp.setTime(time);
			temp.setAveExerciseQuestionNum(aveExerciseQuestionNum);
			temp.setExerciseFeq(exerciseFeq);
			res.add(temp);
		}
		return res;
	}

	public List<UserExeAcurInfoPo> setUserExerciseToMonthAccuracyInfo(
			Sys_User usr) {
		List<String[]> resList=workerOnlineExerciseEstDao.selectAccuracyRateByUserToMonth(usr);
		List<UserExeAcurInfoPo> res=new ArrayList<UserExeAcurInfoPo>();
		for(int i=0;i<resList.size();i++)
		{
			UserExeAcurInfoPo temp=new UserExeAcurInfoPo();
			String id=String.valueOf(i+1);
			String timeString=resList.get(i)[2];
			String accuracyString=resList.get(i)[1];
			String courseString="无记录";
			if(resList.get(i)[3].equals("无记录")==false)
			{
			String[] courseInfo=resList.get(i)[3].split("\\|");
			courseString=courseInfo[0]+"第"+courseInfo[1]+"章";
			}
			temp.setId(id);
			temp.setTimeString(timeString);
			temp.setCourseString(courseString);
			temp.setAccuracyString(accuracyString);
			res.add(temp);
		}
		return res;
	}

	public List<UserExeAcurInfoPo> setUserExerciseToWeekAccuracyInfo(
			Sys_User usr) {
		List<String[]> resList=workerOnlineExerciseEstDao.selectAccuracyRateByUserToWeek(usr);
		List<UserExeAcurInfoPo> res=new ArrayList<UserExeAcurInfoPo>();
		for(int i=0;i<resList.size();i++)
		{
			UserExeAcurInfoPo temp=new UserExeAcurInfoPo();
			String id=String.valueOf(i+1);
			String timeString=resList.get(i)[2];
			String accuracyString=resList.get(i)[1];
			String courseString="无记录";
			if(resList.get(i)[3].equals("无记录")==false)
			{
			String[] courseInfo=resList.get(i)[3].split("\\|");
			courseString=courseInfo[0]+"第"+courseInfo[1]+"章";
			}
			temp.setId(id);
			temp.setTimeString(timeString);
			temp.setCourseString(courseString);
			temp.setAccuracyString(accuracyString);
			res.add(temp);
		}
		return res;
	}

	public List<UserExeAcurInfoPo> setUserExerciseTodayAccuracyInfo(Sys_User usr) {
		List<String[]> resList=workerOnlineExerciseEstDao.selectAccuracyRateByUserToday(usr);
		List<UserExeAcurInfoPo> res=new ArrayList<UserExeAcurInfoPo>();
		for(int i=0;i<resList.size();i++)
		{
			UserExeAcurInfoPo temp=new UserExeAcurInfoPo();
			String id=String.valueOf(i+1);
			String timeString=resList.get(i)[2];
			String accuracyString=resList.get(i)[1];
			String courseString="无记录";
			if(resList.get(i)[3].equals("无记录")==false)
			{
			String[] courseInfo=resList.get(i)[3].split("\\|");
			courseString=courseInfo[0]+"第"+courseInfo[1]+"章";
			}
			temp.setId(id);
			temp.setTimeString(timeString);
			temp.setCourseString(courseString);
			temp.setAccuracyString(accuracyString);
			res.add(temp);
		}
		return res;
	}

	public List<UserExeEstimatePo> setUserExerciseEstimateInfoToMonth(
			Sys_User usr) {
		List<UserExeEstimatePo> resList=new ArrayList<UserExeEstimatePo>();
		List<String[]> resList0=workerOnlineExerciseEstDao.selectAccuracyRateByUserToMonth(usr);
		List<String[]> resList1=workerOnlineExerciseEstDao.selectExerciseFeqByUserToMonth(usr);
		List<String[]> resList2=workerOnlineExerciseEstDao.selectExerciseContentByUserAndTimeArea(usr, "month");
		int size0=resList0.size();
		int size1=resList1.size();
		int size2=resList2.size();
		for(int i=0;i<resList0.size();i++)
		{
			String exerciseContent="无记录";
			if(resList0.get(i)[3].equals("无记录")==false)
			{
			String[] courseInfo=resList0.get(i)[3].split("\\|");
			exerciseContent=courseInfo[0]+"第"+courseInfo[1]+"章";
			String id=String.valueOf(i+1);
			String type="本月练习准确率评价";
			if(Float.parseFloat(resList0.get(i)[1])<0.9)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",不达标,请重新温习"+exerciseContent;
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			else if(Float.parseFloat(resList0.get(i)[1])>=0.9&&Float.parseFloat(resList0.get(i)[1])<=0.95)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",达标,但是在"+exerciseContent+"的练习上还有进步空间";
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			else if(Float.parseFloat(resList0.get(i)[1])>=0.95)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",很高,请根据个人练习量练习"+exerciseContent+"的题目";
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			}
			else
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId("1");
				temp.setType("练习准确率评价");
				temp.setExerciseContent("本月无练习记录");
				temp.setEstimateString("本月无练习记录");
				resList.add(temp);
			}
		}
		for(int j=0;j<resList1.size();j++)
		{
			if(resList1.get(j)[0].equals("0")==true)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId("2");
				temp.setType("练习频率评价");
				temp.setExerciseContent("本月无练习记录");
				temp.setEstimateString("本月无练习记录");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>=1&&Integer.parseInt(resList1.get(j)[0])<=10
					&&Float.parseFloat(resList1.get(j)[2])<=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本月练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",略有不足");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,略有不足,请多做些练习");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>10&&Integer.parseInt(resList1.get(j)[0])<=30
					&&Float.parseFloat(resList1.get(j)[2])<=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本月练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",已经足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,略有不足,请多做些练习");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>10&&Integer.parseInt(resList1.get(j)[0])<=30
					&&Float.parseFloat(resList1.get(j)[2])>10&Float.parseFloat(resList1.get(j)[2])<=30)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本月练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",已经足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,已经足够");
				resList.add(temp);
			}
			else
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本月练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",完全达到要求,做做别的吧");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,完全达到要求,做做别的吧");
				resList.add(temp);
			}
		}
		for(int k=0;k<resList2.size();k++)
		{
			if(resList2.get(k)[0].equals("无记录")==true&&resList2.get(k)[1].equals("无记录")==true
					&&resList2.get(k)[2].equals("无记录")==true)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf("3"));
				temp.setType("本月练习侧重评价");
				temp.setExerciseContent("本月无练习记录");
				temp.setEstimateString("本月无练习记录");
				resList.add(temp);
			}
			else
			{
				if(Integer.parseInt(resList2.get(k)[2])>=1&&Integer.parseInt(resList2.get(k)[2])<=5)
				{
					UserExeEstimatePo temp = new UserExeEstimatePo();
					temp.setId(String.valueOf(size0+size1+k));
					temp.setType("本月练习侧重评价");
					temp.setExerciseContent(resList2.get(k)[0]+"第"+resList2.get(k)[2]+"章");
					temp.setEstimateString("此部分练习量略少，可以多加练习");
					resList.add(temp);
				}
				else if(Integer.parseInt(resList2.get(k)[2])>5)
				{
					UserExeEstimatePo temp = new UserExeEstimatePo();
					temp.setId(String.valueOf(size0+size1+k));
					temp.setType("本月练习侧重评价");
					temp.setExerciseContent(resList2.get(k)[0]+"第"+resList2.get(k)[2]+"章");
					temp.setEstimateString("此部分练习量已经足够,练练别的部分吧");
					resList.add(temp);
				}
			}
		}
		if(errorSetDao.findByErrorSetFlagUsrId(usr, 3).size()!=0)
		{
			UserExeEstimatePo temp = new UserExeEstimatePo();
			temp.setId(String.valueOf(size0+size1+size2+1));
			temp.setType("本月练习侧重评价");
			temp.setExerciseContent("练习推荐");
			temp.setEstimateString("错题集还有掌握不到位的题,请进行练习！");
			resList.add(temp);
		}
		return resList;
	}

	public List<UserExeEstimatePo> setUserExerciseEstimateInfoToWeek(
			Sys_User usr) {
		List<UserExeEstimatePo> resList=new ArrayList<UserExeEstimatePo>();
		List<String[]> resList0=workerOnlineExerciseEstDao.selectAccuracyRateByUserToWeek(usr);
		List<String[]> resList1=workerOnlineExerciseEstDao.selectExerciseFeqByUserToWeek(usr);
		List<String[]> resList2=workerOnlineExerciseEstDao.selectExerciseContentByUserAndTimeArea(usr, "week");
		int size0=resList0.size();
		int size1=resList1.size();
		int size2=resList2.size();
		for(int i=0;i<resList0.size();i++)
		{
			String exerciseContent="无记录";
			if(resList0.get(i)[3].equals("无记录")==false)
			{
			String[] courseInfo=resList0.get(i)[3].split("\\|");
			exerciseContent=courseInfo[0]+"第"+courseInfo[1]+"章";
			String id=String.valueOf(i+1);
			String type="本周练习准确率评价";
			if(Float.parseFloat(resList0.get(i)[1])<0.9)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",不达标,请重新温习"+exerciseContent;
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			else if(Float.parseFloat(resList0.get(i)[1])>=0.9&&Float.parseFloat(resList0.get(i)[1])<=0.95)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",达标,但是在"+exerciseContent+"的练习上还有进步空间";
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			else if(Float.parseFloat(resList0.get(i)[1])>=0.95)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",很高,请根据个人练习量练习"+exerciseContent+"的题目";
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			}
			else
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId("1");
				temp.setType("练习准确率评价");
				temp.setExerciseContent("本周无练习记录");
				temp.setEstimateString("本周无练习记录");
				resList.add(temp);
			}
		}
		for(int j=0;j<resList1.size();j++)
		{
			if(resList1.get(j)[0].equals("0")==true)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId("2");
				temp.setType("练习频率评价");
				temp.setExerciseContent("本周无练习记录");
				temp.setEstimateString("本周无练习记录");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>=1&&Integer.parseInt(resList1.get(j)[0])<=3
					&&Float.parseFloat(resList1.get(j)[2])<=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本周练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",略有不足");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,不足,请多做些练习");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>3&&Integer.parseInt(resList1.get(j)[0])<=5
					&&Float.parseFloat(resList1.get(j)[2])<=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本周练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",基本足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,不足,请多做些练习");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>3&&Integer.parseInt(resList1.get(j)[0])<=5
					&&Float.parseFloat(resList1.get(j)[2])>=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本周练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",基本足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,已经足够");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>5
					&&Float.parseFloat(resList1.get(j)[2])>=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本周练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",已经足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,已经足够");
				resList.add(temp);
			}
		}
		for(int k=0;k<resList2.size();k++)
		{
			if(resList2.get(k)[0].equals("无记录")==true&&resList2.get(k)[1].equals("无记录")==true
					&&resList2.get(k)[2].equals("无记录")==true)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf("3"));
				temp.setType("本周练习侧重评价");
				temp.setExerciseContent("本周无练习记录");
				temp.setEstimateString("本周无练习记录");
				resList.add(temp);
			}
			else
			{
				if(Integer.parseInt(resList2.get(k)[2])>=1&&Integer.parseInt(resList2.get(k)[2])<=3)
				{
					UserExeEstimatePo temp = new UserExeEstimatePo();
					temp.setId(String.valueOf(size0+size1+k));
					temp.setType("本周练习侧重评价");
					temp.setExerciseContent(resList2.get(k)[0]+"第"+resList2.get(k)[2]+"章");
					temp.setEstimateString("此部分练习量正常");
					resList.add(temp);
				}
				else if(Integer.parseInt(resList2.get(k)[2])>=3)
				{
					UserExeEstimatePo temp = new UserExeEstimatePo();
					temp.setId(String.valueOf(size0+size1+k));
					temp.setType("本周练习侧重评价");
					temp.setExerciseContent(resList2.get(k)[0]+"第"+resList2.get(k)[2]+"章");
					temp.setEstimateString("此部分练习量已经足够,练练别的部分吧");
					resList.add(temp);
				}
			}
		}
		if(errorSetDao.findByErrorSetFlagUsrId(usr, 3).size()!=0)
		{
			UserExeEstimatePo temp = new UserExeEstimatePo();
			temp.setId(String.valueOf(size0+size1+size2+1));
			temp.setType("本周练习侧重评价");
			temp.setExerciseContent("练习推荐");
			temp.setEstimateString("错题集还有掌握不到位的题,请进行练习！");
			resList.add(temp);
		}
		return resList;
	}

	public List<UserExeEstimatePo> setUserExerciseEstimateInfoToday(Sys_User usr) {
		List<UserExeEstimatePo> resList=new ArrayList<UserExeEstimatePo>();
		List<String[]> resList0=workerOnlineExerciseEstDao.selectAccuracyRateByUserToday(usr);
		List<String[]> resList1=workerOnlineExerciseEstDao.selectExerciseFeqByUserToday(usr);
		List<String[]> resList2=workerOnlineExerciseEstDao.selectExerciseContentByUserAndTimeArea(usr, "day");
		int size0=resList0.size();
		int size1=resList1.size();
		int size2=resList2.size();
		for(int i=0;i<resList0.size();i++)
		{
			String exerciseContent="无记录";
			if(resList0.get(i)[3].equals("无记录")==false)
			{
			String[] courseInfo=resList0.get(i)[3].split("\\|");
			exerciseContent=courseInfo[0]+"第"+courseInfo[1]+"章";
			String id=String.valueOf(i+1);
			String type="本日练习准确率评价";
			if(Float.parseFloat(resList0.get(i)[1])<0.9)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",不达标,请重新温习"+exerciseContent;
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			else if(Float.parseFloat(resList0.get(i)[1])>=0.9&&Float.parseFloat(resList0.get(i)[1])<=0.95)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",达标,但是在"+exerciseContent+"的练习上还有进步空间";
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			else if(Float.parseFloat(resList0.get(i)[1])>=0.95)
			{
				String estimateString="练习准确率为"+resList0.get(i)[1]+",很高,请根据个人练习量练习"+exerciseContent+"的题目";
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(id);
				temp.setType(type);
				temp.setExerciseContent(exerciseContent);
				temp.setEstimateString(estimateString);
				resList.add(temp);
			}
			}
			else
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId("1");
				temp.setType("练习准确率评价");
				temp.setExerciseContent("今日无练习记录");
				temp.setEstimateString("今日无练习记录");
				resList.add(temp);
			}
		}
		for(int j=0;j<resList1.size();j++)
		{
			if(resList1.get(j)[0].equals("0")==true)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId("2");
				temp.setType("练习频率评价");
				temp.setExerciseContent("今日无练习记录");
				temp.setEstimateString("今日无练习记录");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>=1
					&&Float.parseFloat(resList1.get(j)[2])<=10)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本日练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",已经足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,略有不足,请多做些练习");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>=1
					&&Float.parseFloat(resList1.get(j)[2])>10&&Float.parseFloat(resList1.get(j)[2])<=30)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本日练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",已经足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,已经足够,多看些其他的吧");
				resList.add(temp);
			}
			else if(Integer.parseInt(resList1.get(j)[0])>=1
					&&Float.parseFloat(resList1.get(j)[2])>30)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf(size0+j));
				temp.setType("本日练习频率评价");
				temp.setExerciseContent("练习次数为"+resList1.get(j)[0]+",已经足够");
				temp.setEstimateString("平均练习量为"+resList1.get(j)[2]+"题,已经足够");
				resList.add(temp);
			}
		}
		for(int k=0;k<resList2.size();k++)
		{
			if(resList2.get(k)[0].equals("无记录")==true&&resList2.get(k)[1].equals("无记录")==true
					&&resList2.get(k)[2].equals("无记录")==true)
			{
				UserExeEstimatePo temp = new UserExeEstimatePo();
				temp.setId(String.valueOf("3"));
				temp.setType("本日练习侧重评价");
				temp.setExerciseContent("今日无练习记录");
				temp.setEstimateString("今日无练习记录");
				resList.add(temp);
			}
			else
			{
				if(Integer.parseInt(resList2.get(k)[2])>=1&&Integer.parseInt(resList2.get(k)[2])<=3)
				{
					UserExeEstimatePo temp = new UserExeEstimatePo();
					temp.setId(String.valueOf(size0+size1+k));
					temp.setType("本日练习侧重评价");
					temp.setExerciseContent(resList2.get(k)[0]+"第"+resList2.get(k)[2]+"章");
					temp.setEstimateString("此部分练习量正常");
					resList.add(temp);
				}
				else if(Integer.parseInt(resList2.get(k)[2])>=3)
				{
					UserExeEstimatePo temp = new UserExeEstimatePo();
					temp.setId(String.valueOf(size0+size1+k));
					temp.setType("本日练习侧重评价");
					temp.setExerciseContent(resList2.get(k)[0]+"第"+resList2.get(k)[2]+"章");
					temp.setEstimateString("此部分练习量已经足够,练练别的部分吧");
					resList.add(temp);
				}
			}
		}
		if(errorSetDao.findByErrorSetFlagUsrId(usr, 3).size()!=0)
		{
			UserExeEstimatePo temp = new UserExeEstimatePo();
			temp.setId(String.valueOf(size0+size1+size2+1));
			temp.setType("本日练习侧重评价");
			temp.setExerciseContent("练习推荐");
			temp.setEstimateString("错题集还有掌握不到位的题,请进行练习！");
			resList.add(temp);
		}
		return resList;
	}

	public String setAccuracyString(Sys_User usr) {
		List<String[]> resUserYear=workerOnlineExerciseEstDao.selectAccuracyRateByUserPerMonth(usr);
		String monthAccuracyCount = "{\"chart\":{\"caption\":\"各月份练习准确率变化\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":[{\"category\":[{\"label\":\"1月\"},{\"label\":\"2月\"},{\"label\":\"3月\"},{\"label\":\"4月\"},{\"label\":\"5月\"},{\"label\":\"6月\"},{\"label\":\"7月\"},{\"label\":\"8月\"},{\"label\":\"9月\"},{\"label\":\"10月\"},{\"label\":\"11月\"},{\"label\":\"12月\"}]}],\"dataset\":[";
		String monthAccuracyTotal = "{\"seriesname\":\"准确率\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String monthAccuracyEvg = "{\"seriesname\":\"建议值\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for(int i = 1;i < resUserYear.size()+1;i++){
			if(i!=resUserYear.size()){
				monthAccuracyTotal += "{\"value\":\""+resUserYear.get(i-1)[0]+"\"},";
				monthAccuracyEvg += "{\"value\":\""+"0.9"+"\"},";
			}else{
				monthAccuracyTotal += "{\"value\":\""+resUserYear.get(i-1)[0]+"\"}]},";
				monthAccuracyEvg += "{\"value\":\""+"0.9"+"\"}]}]}";
				}
		}
		monthAccuracyCount+=monthAccuracyTotal+monthAccuracyEvg;
		return monthAccuracyCount;
	}

	public String setFeqString(Sys_User usr) {
		List<String[]> resUserYear=workerOnlineExerciseEstDao.selectExerciseFeqByUserPerMonth(usr);
		String monthFeqCount = "{\"chart\":{\"caption\":\"各月份练习频率变化\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":[{\"category\":[{\"label\":\"1月\"},{\"label\":\"2月\"},{\"label\":\"3月\"},{\"label\":\"4月\"},{\"label\":\"5月\"},{\"label\":\"6月\"},{\"label\":\"7月\"},{\"label\":\"8月\"},{\"label\":\"9月\"},{\"label\":\"10月\"},{\"label\":\"11月\"},{\"label\":\"12月\"}]}],\"dataset\":[";
		String monthFeqTotal = "{\"seriesname\":\"频率\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String monthFeqEvg = "{\"seriesname\":\"建议值\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for(int i = 1;i < resUserYear.size()+1;i++){
			if(i!=resUserYear.size()){
				monthFeqTotal += "{\"value\":\""+resUserYear.get(i-1)[0]+"\"},";
				monthFeqEvg += "{\"value\":\""+"15"+"\"},";
			}else{
				monthFeqTotal += "{\"value\":\""+resUserYear.get(i-1)[0]+"\"}]},";
				monthFeqEvg += "{\"value\":\""+"15"+"\"}]}]}";
				}
		}
		monthFeqCount+=monthFeqTotal+monthFeqEvg;
		return monthFeqCount;
	}
}


