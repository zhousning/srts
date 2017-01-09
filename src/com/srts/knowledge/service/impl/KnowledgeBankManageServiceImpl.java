package com.srts.knowledge.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.srts.knowledge.dao.KlgBankManDao;
import com.srts.knowledge.domain.Experience;
import com.srts.knowledge.domain.RuleLearning;
import com.srts.knowledge.domain.TypicalCase;
import com.srts.knowledge.domain.TypicalViolation;
import com.srts.knowledge.service.KnowledgeBankManageService;

@Service
public class KnowledgeBankManageServiceImpl implements
		KnowledgeBankManageService {

	@Resource
	private KlgBankManDao bankManDao;

	/**
	 * 查询知识的前五条记录
	 */
	public List<Experience> findTopFiveExperiences() {
		List<Experience> experiences = null;
		experiences = bankManDao.findTopFiveExperiences();
		return experiences;
	}

	public List<TypicalCase> findTopFiveTypicalCases() {
		List<TypicalCase> typicalCases = null;
		typicalCases = bankManDao.findTopFiveTypicalCases();
		return typicalCases;
	}

	public List<TypicalViolation> findTopFiveTypicalViolations() {
		List<TypicalViolation> typicalViolations = null;
		typicalViolations = bankManDao.findTopFiveTypicalViolations();
		return typicalViolations;
	}

	/**
	 * 按知识类型查询所有记录
	 */
	public List<Object[]> findAllByType(String klgType) {
		List<Object[]> list = null;
		list = bankManDao.findAllByType(klgType);
		return list;
	}

	/**
	 * 删除某条记录
	 */
	public void deleteKle(String klgType, long klgId) {
		bankManDao.deleteKlg(klgType,klgId);
	}

	/**
	 * 根据知识id获取响应的知识内容
	 */
	public List<Object[]> findContenById(long klgId,String klgType) {
		List<Object[]> list=null;
		System.out.println("service:*************"+klgId);
		list=bankManDao.findContentById(klgId,klgType);
		return list;
	}

	/**
	 * 更新知识
	 */
	public void updateKlg(long klgId, String klgType, String updateTime,String title, String content, String type) {
		bankManDao.updateKlg(klgId,klgType,updateTime,title,content,type);
		
	}

	/**
	 * 根据Id查找相应的操作经验实体
	 */
	public Experience findExpById(long klgId) {
		Experience experience=null;
		experience=bankManDao.getById(klgId);
		return experience;
	}

	/**
	 * 更新操作经验
	 */
	public void upDateExp(Experience experience) {
		bankManDao.update(experience);
	}

	/**
	 * 知识上传
	 */
	public void upLoadKlg(String klg,String title, String dates, String content,long userId) {
		bankManDao.upLoadKlg(klg,title,dates,content,userId);
	}

	/**
	 * 上传典型案例图片
	 */
	public String upLoadTpc(String klg, List<File> caseImg,
			List<String> caseImgFileName,long userId) {
		ServletContext context=ServletActionContext.getServletContext();
		String rpath="resource/image/knowledge/upLoad/#";
		String path=context.getRealPath("/resource/image/knowledge/upLoad/");
		String newName="";
		
		System.out.println(path);
		File file=new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		
		for(int i=0;i<caseImg.size();i++){
			try {
				newName="usr"+userId+"td"+System.currentTimeMillis()+"."+caseImgFileName.get(i).split("[.]")[1];
				rpath+=newName+"#";
				FileUtils.copyFile(caseImg.get(i), new File(file,newName));
				System.out.println("********type"+caseImgFileName.get(i).split("[.]")[1]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("路径："+rpath);
		
		return rpath;
	}

	/**
	 * 上传典型案例
	 */
	public void upLoadTypeCase(String klg, String title, String content,
			String path,String dates) {
		bankManDao.upLoadTypeCase(klg,title,content,path,dates);
	}

}
