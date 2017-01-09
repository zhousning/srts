package com.srts.examination.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.srts.examination.service.ExaminationPaperManageService;
import com.srts.utils.docUtils.DocOperationUtil;

@Service
public class ExaminationPaperManageServiceImpl implements ExaminationPaperManageService {
	
	public String getExaminationPaperOut() {
		//组成html文件的名称
		String outputYear = new Date().getYear()+1900+"";
		String outputMonth = new Date().getMonth()+1+"";
		String outputDay = new Date().getDate()+"";
		String paperName = "exampaper-"+outputYear+"-"+outputMonth+"-"+outputDay;
		//考试试卷doc
		String examPaperDoc = null;
		//考试试卷html
		String examPaperHtml = null;
		examPaperDoc = ServletActionContext.getServletContext().getRealPath("/resource/templete/examination/doc/" + paperName+ ".doc");
		examPaperHtml = ServletActionContext.getServletContext().getRealPath("/resource/templete/examination/html/" + paperName+ ".html");
		//生成试卷word
		File docFile = new File(examPaperDoc);
		if(!docFile.exists()){
			try {
				docFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//第一步、打开word文档
		DocOperationUtil util = new DocOperationUtil();
		util.openDoc(examPaperDoc.replace("//", "/"));
		//从数据库中查询出试题（这部分需要重写）
		List<String> questList = new ArrayList<String>();//此处执行数据库操作,我写的只是一个模拟生成数据库中的试题，此处具体List要从数据中获取
		questList.add("违章分为(    )违章、(     )违章和(    ) 违章三类。");
		questList.add("违章分为(    )违章、(     )违章和(    ) 违章三类。");
		questList.add("违章分为(    )违章、(     )违章和(    ) 违章三类。");
		questList.add("违章分为(    )违章、(     )违章和(    ) 违章三类。");
		questList.add("违章分为(    )违章、(     )违章和(    ) 违章三类。");
		//第二步、执行数据后查询操作后，对试题进行遍历，往word里插入试题
		int i = 1;
		for(String quest:questList){
			String content = i+"、"+quest+"\n";
			util.insertTest(content);
			i++;
		}
		//第三步、待试题插入 完成后，将doc文件转换成html文件，用于显示
		util.saveDoc2Html(examPaperDoc.replace("//", "/"), examPaperHtml.replace("//", "/"));
		return paperName;
	}

}
