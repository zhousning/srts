package com.srts.learning.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.information.domain.TrainNotice;
import com.srts.learning.dao.OnlineCourseTraceManageDao;
import com.srts.learning.po.OnlineCourseTracePo;
import com.srts.learning.service.OnlineCourseTraceManageService;

@Service
public class OnlineCourseTraceManageServiceImpl implements OnlineCourseTraceManageService {
	
	@Resource
	private OnlineCourseTraceManageDao dao;
	
	/**
	 * 根据年和月获取员工学习记录
	 * @param list
	 * @return
	 */
	public List<OnlineCourseTracePo> getCourseTracePo(int year,int month){
		List<Object[]> list = dao.getAllUserStudyTrace(year, month);
		OnlineCourseTracePo po = new OnlineCourseTracePo();
		List<OnlineCourseTracePo> poList = po.getCourseTracePo(list);
		return poList;
	}
	
	/**
	 * 根据page获取list   ---
	 * @param page
	 * @param year
	 * @param month
	 * @return
	 */
	public List<OnlineCourseTracePo> getCourseTracePoByPage(int page,int year,int month){
		int perPage = 8;//每页显示多少条记录
		int min = (page-1)*perPage;
		int max = perPage;
		List<Object[]> list = dao.getAllUserCourseTrace(year, month, min, max);
		OnlineCourseTracePo po = new OnlineCourseTracePo();
		List<OnlineCourseTracePo> poList = po.getCourseTracePo(list);
		return poList;
	}
	
	/**
	 * 可分多少页
	 * @param year
	 * @param month
	 * @return
	 */
	public Integer getCourseTraceTotalPages(int year,int month){
		Integer perPage = 8;//每页显示多少条记录
		Integer totalPage =0;
		Integer totalCount = 0;
		totalCount = dao.getUsrCourseTraceCount(year, month);
		totalPage = totalCount/perPage+1;
		return totalPage;
	}
	
	/**
	 *
	 * 根据年获取trainnotice
	 * @param year
	 */
	public List<TrainNotice> getOnlineCourseNoticeTitle(int noticeYear){
		return dao.getOnlineCourseNoticeTitle(noticeYear);
	}
	
	/**
	 * 根据条件查询学习记录
	 * @param pageNum
	 * @param noticeYear
	 * @param noticeMonth
	 * @param usrName
	 * @param majorName
	 * @param companyName
	 * @param noticeTitle
	 * @return
	 */
	public List<OnlineCourseTracePo> getCourseTraceQueryByOptions(int pageNum,int noticeYear,int noticeMonth,String usrName,String majorName,String companyName,String noticeTitle){
		int perPage = 8;//每页显示多少条记录
		int min = (pageNum-1)*perPage;
		int max = perPage;
		
		Map<String,String> options = new HashMap<String,String>();
		String optionMatch="";
		if(usrName!=null && !usrName.equals("")){
			options.put("w", usrName);
			optionMatch+="w ";
		}
		if(majorName!=null && !majorName.equals("")){
			options.put("a", majorName);
			optionMatch+="a ";
		}
		if(companyName!=null && !companyName.equals("")){
			options.put("n", companyName);
			optionMatch+="n ";
		}
		if(noticeTitle!=null && !noticeTitle.equals("")){
			options.put("g", noticeTitle);
			optionMatch+="g ";
		}
		List<Object[]> list = dao.getUserStudyTraceQueryByOptions(noticeYear, noticeMonth, options, optionMatch, max, min);
		OnlineCourseTracePo po = new OnlineCourseTracePo();
		List<OnlineCourseTracePo> poList = po.getCourseTracePo(list);
		return poList;
	}
	
	/**
	 * 条件查询可分多少页
	 * @param noticeYear
	 * @param noticeMonth
	 * @param usrName
	 * @param majorName
	 * @param companyName
	 * @param noticeTitle
	 * @return
	 */
	public Integer getCourseTraceTotalPages(int noticeYear,int noticeMonth,String usrName,String majorName,String companyName,String noticeTitle){
		Map<String,String> options = new HashMap<String,String>();
		String optionMatch="";
		if(usrName!=null){
			options.put("w", usrName);
			optionMatch+="w";
		}
		if(majorName!=null){
			options.put("a", majorName);
			optionMatch+="a";
		}
		if(companyName!=null){
			options.put("n", companyName);
			optionMatch+="n";
		}
		if(noticeTitle!=null){
			options.put("g", noticeTitle);
			optionMatch+="g";
		}
		Integer perPage = 8;//每页显示多少条记录
		Integer totalPage =0;
		Integer totalCount = 0;
		totalCount = dao.getCourseTraceCountQueryByOptions(noticeYear, noticeMonth, options, optionMatch);
		totalPage = totalCount/perPage+1;
		return totalPage;
	}
	
	/**
	 * 根据月份获取员工的个人学习记录
	 */
	public String userStudyTraceRecord(long userID,int noticeYear,int noticeMonth,String noticeTitle){
		String userTraceRecord = "{\"chart\": {\"valueposition\": \"auto\",\"rotatevalues\": \"1\",\"showvalues\": \"1\",\"linealpha\": \"85\",\"linecolor\": \"FF5904\",\"basefontcolor\": \"666666\",\"canvasbordercolor\": \"666666\",\"alternatehgridalpha\":\"5\",\"divlinealpha\": \"20\",\"divlinecolor\": \"ff5904\",\"alternatehgridcolor\": \"ff5904\",\"showalternatehgridcolor\": \"1\",\"animation\": \"1\",\"showcolumnshadow\": \"1\",\"showlabels\": \"1\",\"yaxisname\": \"时长\",\"xaxisname\": \"日期\",\"caption\": \"学习记录\",\"canvaspadding\": \"10\"},\"data\": [";
		String userRecord = dao.getUserOnlineCourseTraceRecord(userID, noticeYear, noticeMonth, noticeTitle);
		String[] records = userRecord.split(",");
		for(int i = 0;i<records.length;i++){
			if(i!=(records.length-1)){
				String[]r = records[i].split("[|]");
				userTraceRecord +="{\"value\":\""+r[1]+"\",\"label\":\""+r[0]+"\"},";
			}else{
				String[]r = records[i].split("[|]");
				userTraceRecord +="{\"value\":\""+r[1]+"\",\"label\":\""+r[0]+"\"}";
			}
		}
		userTraceRecord +="]}";
		return userTraceRecord;
	}
	
	/**
	 * 根据月份获取每个月学习时间
	 * @param year
	 * @param month
	 * @return
	 */
	public String getMonthStudyTimeCount(int year){
		String monthStudyTimeCount = "{\"chart\":{\"caption\":\"各月份学习总时/均时变化\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":[{\"category\":[{\"label\":\"1月\"},{\"label\":\"2月\"},{\"label\":\"3月\"},{\"label\":\"4月\"},{\"label\":\"5月\"},{\"label\":\"6月\"},{\"label\":\"7月\"},{\"label\":\"8月\"},{\"label\":\"9月\"},{\"label\":\"10月\"},{\"label\":\"11月\"},{\"label\":\"12月\"}]}],\"dataset\":[";
		//int userCount = daogetCompanyUserNumCount();
		int userCount = 1000;
		String monthStudyTimeTotal = "{\"seriesname\":\"总时\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String monthStudyTimeEvg = "{\"seriesname\":\"均时\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for(int i = 1;i < 13;i++){
			BigDecimal a = dao.getMonthStudyTimeCount(year, i);
			if(i!=12){
				if(a!=null){
					monthStudyTimeTotal += "{\"value\":\""+a.intValue()+"\"},";
					monthStudyTimeEvg += "{\"value\":\""+(float)(a.intValue()/userCount)+"\"},";
				}else{
					monthStudyTimeTotal += "{\"value\":\"0\"},";
					monthStudyTimeEvg += "{\"value\":\"0\"},";
				}
			}else{
				if(a!=null){
					monthStudyTimeTotal += "{\"value\":\""+a.intValue()+"\"}]},";
					monthStudyTimeEvg += "{\"value\":\""+(float)(a.intValue()/userCount)+"\"}]}]}";
				}else{
					monthStudyTimeTotal += "{\"value\":\"0\"}]},";
					monthStudyTimeEvg += "{\"value\":\"0\"}]}]}";
				}
			}
		}
		monthStudyTimeCount+=monthStudyTimeTotal+monthStudyTimeEvg;
		return monthStudyTimeCount;
	}
}
