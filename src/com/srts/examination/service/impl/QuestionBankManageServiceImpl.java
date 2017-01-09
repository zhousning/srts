package com.srts.examination.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.srts.examination.dao.CompetitionDao;
import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.QuestionBankManageService;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.ErrorSetDao;
@Service
@SuppressWarnings("unchecked")
public class QuestionBankManageServiceImpl implements QuestionBankManageService {
	@Resource
	private QuestionBankManageDao questionBankManageDao;
	@Resource
    private ErrorSetDao errorSetDao;
	@Resource
    private CompetitionDao competitionDao;
	public int deleteQuestionById(long id) {
		int res=0;
		System.out.println(res);
		int resDelErrorSet=errorSetDao.deleteByQuestionId(id);
		int resDelCompetition=competitionDao.deleteCompetitionErrorByQuestionId(id);
		int resDelQuestionBank=questionBankManageDao.deleteQuestionById(id);
		System.out.println(resDelErrorSet);
		System.out.println(resDelCompetition);
		System.out.println(resDelQuestionBank);
		if(resDelQuestionBank>0)
		{
			res=1;
		}
		return res;
	}

	public List<String[]> findAllQuestion() {
		List list=questionBankManageDao.findAllQuestion();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}
	
	public List<String[]> findAllQuestionUpdateTimeDesc() {
		List list=questionBankManageDao.findAllQuestionUpdateTimeDesc();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}
	
	public List<String[]> findAllQuestionUploadTimeDesc() {
		List list=questionBankManageDao.findAllQuestionUploadTimeDesc();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public QuestionBank findQuestionById(long id) {
		QuestionBank res=new QuestionBank();
		QuestionBank question=questionBankManageDao.findQuestionById(id);
		if(question!=null)
		{
			res=question;
		}
		else
		{
			BookChapter b=new BookChapter();
			b.setId(0);
			QuestionBank empty=new QuestionBank(((long)0),"无记录","无记录","无记录","无记录",
					b,"无记录","无记录",0);
			res=empty;
		}
		return res;
	}

	
	public List<String[]> findQuestionByKeyWords(String key) {
		List list=questionBankManageDao.findQuestionByKeyWords(key);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> findQuestionByType(String type) {
		List list=questionBankManageDao.findQuestionByType(type);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public int insertQuestionBank(String type, String content, String answer,
			String bookName, String chapterNum, String questionPic, String uploadTime, String lastUpdateTime, int selectOptions) {
		BookChapter bookChapter=questionBankManageDao.getBookChapterId(bookName, chapterNum);
		int res=questionBankManageDao.insertQuestionBank(type, content, answer, bookChapter, questionPic, uploadTime, lastUpdateTime, selectOptions);
		return res;
	}

	public int updateQuestionAnswerById(long id, String answer) {
		int res=0;
		int resAnswer=questionBankManageDao.updateQuestionAnswerById(id, answer);
		if(resAnswer==1)
		{
			Calendar calendar=Calendar.getInstance();
			String year=String.valueOf(calendar.get(Calendar.YEAR));
			String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
			String date=String.valueOf(calendar.get(Calendar.DATE));
			if(month.length()==1)
			{
				month="0"+month;
			}
			if(date.length()==1)
			{
				date="0"+date;
			}
			String lastUpdateTime=year+"-"+month+"-"+date;
			int resLastUpdateDate=questionBankManageDao.updateLastUpdateTimeById(id, lastUpdateTime);
			res=1;
		}
		return res;
	}

	public int updateQuestionContentById(long id, String content, int selectOptions) {
		int res=0;
		int resContent=questionBankManageDao.updateQuestionContentById(id, content);
		int resSelectOptions=questionBankManageDao.updateQuestionSelectOptionsById(id, selectOptions);
		if(resContent==1&&resSelectOptions==1)
		{
			Calendar calendar=Calendar.getInstance();
			String year=String.valueOf(calendar.get(Calendar.YEAR));
			String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
			String date=String.valueOf(calendar.get(Calendar.DATE));
			if(month.length()==1)
			{
				month="0"+month;
			}
			if(date.length()==1)
			{
				date="0"+date;
			}
			String lastUpdateTime=year+"-"+month+"-"+date;
			int resLastUpdateDate=questionBankManageDao.updateLastUpdateTimeById(id, lastUpdateTime);
			res=1;
		}
		return res;
	}

	public List<String[]> findQuestionByTypeAndKeyWords(String type, String key) {
		List list=questionBankManageDao.findQuestionByTypeAndKeyWords(type, key);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public String findUploadQuestionNumPerKind() {
		String[] kind={"单选题","多选题","判断题","填空题","改错题","名词解释","简答题","问答题"};
		int tag=0;
		List<Integer> list =  new ArrayList<Integer>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String currentTime=year+"-"+month+"-"+date;
		list=questionBankManageDao.findUploadQuestionNumPerKind(currentTime);
		String updateQuestionNumPerKind = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'当前各类型错题数目累计','xAxisName':'题目类型','yAxisName':'上传题目个数','numberPrefix':'题'},'data':[";
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer obj =  iterator.next();
			String countAmount = obj.toString();			
			String questionType = kind[tag];
			tag++;
			updateQuestionNumPerKind+="{'label':'"+questionType+"','value':'"+countAmount+"'},";
		}
		updateQuestionNumPerKind+="]}";
		return updateQuestionNumPerKind;
	}

	public String findUploadQuestionNumPerMonth() {
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String currentTime=year+"-"+month+"-"+date;
		List<Integer> list = questionBankManageDao.findUploadQuestionNumPerMonth(currentTime);
		String numPerMonth = "{'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','divlinecolor': '91AF46','xaxisname': '月份','yaxisname':'上传题目数目','caption': '上传题目数目统计变化趋势','divlinealpha': '30','showvalues': '0','bgcolor': '009b83,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '30'}," +
		"'data':[";
		for(int i = 0;i<list.size();i++){
			String num = list.get(i).toString();
			numPerMonth+="{'value':'"+num+"','label':'"+Integer.toString(i+1)+"'},";
		}	
		numPerMonth+="]," +
		"'trendlines':[{'line':[" +
		"{'color': 'BC9F3F','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '上传很多','endvalue': '50','startvalue': '30'}," +
		"{'color': '894D1B','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '上传较多','endvalue': '30','startvalue': '20'}," +
		"{'color': '000111','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '上传较少','endvalue': '20','startvalue': '10'}," +
		"{'color': 'f7ab00','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '上传很少','endvalue': '10','startvalue': '0'},]}]}";
		return numPerMonth;
	}

	public List<String[]> findQuestionNumByType() {
		String[] kind={"单选题","多选题","判断题","填空题","改错题","名词解释","简答题","问答题"};
		List<String[]> resList=new ArrayList<String[]>();
		List<Integer> resourceList=new ArrayList<Integer>();
		resourceList=questionBankManageDao.findQuestionNumByType();
		for(int i=0;i<resourceList.size();i++)
		{
			String[] addItem={kind[i],String.valueOf(resourceList.get(i))};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> findTopFiveQuestionOrderByUploadTime() {
		List list=questionBankManageDao.findTopFiveQuestionOrderByUploadTime();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[7].toString(),"增加问题:"+objs[2].toString().substring(0,8)+"...","类型:"+objs[1].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> findTopFiveQuestionOrderBylastUpdateTime() {
		List list=questionBankManageDao.findTopFiveQuestionOrderBylastUpdateTime();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[6].toString(),"修改问题:"+objs[2].toString().substring(0,8)+"...","类型:"+objs[1].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}
	
	/**
	 * 
	 * @param excelPath
	 * @return
	 */
	public String saveQuestionInfo(String excelPath){
		String result = "";
		try {
			InputStream is = new FileInputStream(excelPath);
			Workbook workbook = Workbook.getWorkbook(is);
			Sheet[] sheets = workbook.getSheets();
			Cell[]options = null;
			for(Sheet sheet:sheets){
				int rowCount = sheet.getRows();
				int colCount = 0;
				for(int i=1;i<rowCount;i++){
					//0:type,1:content,2:num,3、pic:,4:ans,5:chapter,6,book
					QuestionBank question = new QuestionBank();
					options = sheet.getRow(i);
					Cell cell = options[0];
					colCount = options.length;
					String questionType = "";
					String questionContent = "";
					String questionNum = "";
					String questionPic = "";
					String questionAns = "";
					String chapterNum = "";
					String bookName = "";
					for(int j = 0;j<colCount;j++){
						switch(j){
						case 0: 
							questionType = options[j].getContents();
							break;
						case 1: 
							questionContent = options[j].getContents();
							break;
						case 2: 
							questionNum = options[j].getContents();
							break;
						case 3: 
							questionPic = options[j].getContents();
							break;
						case 4: 
							questionAns = options[j].getContents();
							break;
						case 5: 
							chapterNum = options[j].getContents();
							break;
						case 6: 
							bookName = options[j].getContents();
							break;
						}
					}
					if(questionType!=""&& questionContent!=""&&questionNum!=""&&questionAns!=""&&chapterNum!=""&&bookName!=""){
						question.setType(questionType);
						question.setContent(questionContent);
						question.setSelectOptions(Integer.parseInt(questionNum));
						question.setQuestionPic(questionPic);
						question.setAnswer(questionAns);
						BookChapter chapter = questionBankManageDao.getBookChapterId(bookName, chapterNum);
						question.setBookChapter(chapter);
						Calendar calendar=Calendar.getInstance();
						String year=String.valueOf(calendar.get(Calendar.YEAR));
						String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
						String date=String.valueOf(calendar.get(Calendar.DATE));
						if(month.length()==1)
						{
							month="0"+month;
						}
						if(date.length()==1)
						{
							date="0"+date;
						}
						String formateDate=year+"-"+month+"-"+date;
						question.setUploadTime(formateDate);
						question.setLastUpdateTime(formateDate);
						int res=questionBankManageDao.insertQuestionBank(questionType, questionContent, questionAns, chapter, questionPic, formateDate, formateDate, Integer.parseInt(questionNum));
						result = "上传成功";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateQuestionPicById(long id, String questionPic) {
		int res=0;
		int resAnswer=questionBankManageDao.updateQuestionPicById(id, questionPic);
		if(resAnswer==1)
		{
			Calendar calendar=Calendar.getInstance();
			String year=String.valueOf(calendar.get(Calendar.YEAR));
			String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
			String date=String.valueOf(calendar.get(Calendar.DATE));
			if(month.length()==1)
			{
				month="0"+month;
			}
			if(date.length()==1)
			{
				date="0"+date;
			}
			String lastUpdateTime=year+"-"+month+"-"+date;
			int resLastUpdateDate=questionBankManageDao.updateLastUpdateTimeById(id, lastUpdateTime);
			res=1;
		}
		return res;
	}

	public String saveQuestionPic(File questionPicture, String updateQuestionPic) {
		File uploadFile=null;
		String returnString=null;
		try {   
			     InputStream in = new FileInputStream(questionPicture);   
			     String dir = ServletActionContext.getServletContext().getRealPath("/resource/image/examination");  
			     //System.out.println(dir);
		         File fileLocation = new File(dir);  
			     //此处也可以在应用根目录手动建立目标上传目录   
		         if(!fileLocation.exists()){  
		               boolean isCreated  = fileLocation.mkdir();
			     }  
			     String fileName=(new StringBuilder(String.valueOf((new Date()).getTime()))).append(".jpg").toString();
			     updateQuestionPic=(new StringBuilder(String.valueOf((new Date()).getTime()))).append(".jpg").toString();
			     String uploadFileTemp = dir+"\\"+fileName;
			     File directory=null;
			     String []filePath=uploadFileTemp.toLowerCase().split("\\\\");
			     String uploadFileName=filePath[0]+"\\";
                 for(int i=1;i<filePath.length-1;i++)
                 {
                	 uploadFileName+=filePath[i]+"\\";
                	 directory = new File(uploadFileName);   
                	 directory.mkdirs();   
                 }
                 uploadFile = new File(uploadFileName +"\\"+fileName);
                 returnString=filePath[4]+"\\"+filePath[5]+"\\"+filePath[6]+"\\"+fileName;
		         OutputStream out = new FileOutputStream(uploadFile);   
			     byte[] buffer = new byte[1024 * 1024];   
		         int length;   
		         while ((length = in.read(buffer)) > 0) { 
		        	 System.out.println(length);
			           out.write(buffer, 0, length);   
			     }   
		         in.close();   
			     out.close();   
			     } catch (FileNotFoundException ex) {   
			     System.out.println("上传失败!");  
			     ex.printStackTrace();   
			     } catch (IOException ex) {   
			     System.out.println("上传失败!");  
		         ex.printStackTrace();}
			     return (returnString);
	}    

	public void saveQuestionPicData(String s) {
		try {
			java.io.InputStream is = new FileInputStream(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String saveQuestionBank(File uploadQuestionBank) {
		String realpath = ServletActionContext.getServletContext().getRealPath("/resources/document/examination");
		File uploadFile=null;
		String returnString=null;
		try {   
			     InputStream in = new FileInputStream(uploadQuestionBank);   
			     String dir = ServletActionContext.getServletContext().getRealPath("/resource/document/examination");  
			     System.out.println(dir);
		         File fileLocation = new File(dir);  
			     //此处也可以在应用根目录手动建立目标上传目录   
		         if(!fileLocation.exists()){  
		               boolean isCreated  = fileLocation.mkdir();
			     }  
			     String fileName=(new StringBuilder(String.valueOf((new Date()).getTime()))).append(".xls").toString();
			     String uploadFileTemp = dir+"\\"+fileName;
			     File directory=null;
			     String []filePath=uploadFileTemp.toLowerCase().split("\\\\");
			     String uploadFileName=filePath[0]+"\\";
			     System.out.println(uploadFileTemp);
                 for(int i=1;i<filePath.length-1;i++)
                 {
                	 uploadFileName+=filePath[i]+"\\";
                	 directory = new File(uploadFileName);   
                	 directory.mkdirs();   
                 }
                 uploadFile = new File(uploadFileName +"\\"+fileName);
                 System.out.println(uploadFile);
                 returnString=uploadFile.getPath().toLowerCase();
                 System.out.println(returnString);
		         OutputStream out = new FileOutputStream(uploadFile);   
			     byte[] buffer = new byte[1024 * 1024];   
		         int length;   
		         while ((length = in.read(buffer)) > 0) { 
		        	 System.out.println(length);
			           out.write(buffer, 0, length);   
			     }   
		         in.close();   
			     out.close();   
			     } catch (FileNotFoundException ex) {   
			     System.out.println("上传失败!");  
			     ex.printStackTrace();   
			     } catch (IOException ex) {   
			     System.out.println("上传失败!");  
		         ex.printStackTrace();}
			     return (returnString);
	}

	public List<QuestionBank> findQuestionBank(String hql) {
		// TODO Auto-generated method stub
		return questionBankManageDao.findQuestionBank(hql);
	}

	public List<QuestionBank> findByIds(String content) {
		List<QuestionBank> questionBanks=null;
		String[] cStrings=content.split(",");
		Long[] ids=new Long[cStrings.length];
		for (int i = 0; i < ids.length; i++) {
			ids[i]=Long.parseLong(cStrings[i]);
		}
		questionBanks=questionBankManageDao.getByIds(ids);
		return questionBanks;
	}
}
