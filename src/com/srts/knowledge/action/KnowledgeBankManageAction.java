package com.srts.knowledge.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.Experience;
import com.srts.knowledge.domain.RuleLearning;
import com.srts.knowledge.domain.TypicalCase;
import com.srts.knowledge.domain.TypicalViolation;
import com.srts.knowledge.service.KnowledgeBankManageService;
import com.srts.system.domain.Sys_User;

@Controller
@Scope("prototype")
public class KnowledgeBankManageAction extends BaseActionImpl<Book> {
	private static final long serialVersionUID = 1L;
	private Book book = new Book();

	private List<TypicalCase> topFiveTypicalCases;
	private List<TypicalViolation> topFiveTypicalViolation;
	private List<Experience> topFiveExperiences;

	private List<TypicalCase> typicalCases;
	private List<TypicalViolation> typicalViolations;
	private List<Experience> experiences;

	private List<Object[]> typeContent;

	private File kndFile;
	private String kndFileFileName;
	private String klgType;
	private long klgId;
	private long userId;
	private String title;
	private String content;
	private String type;
	private String[] pic;

	private List<File> caseImg;
	private List<String> caseImgFileName;

	@Resource
	private KnowledgeBankManageService bankManageService;

	public Book getModel() {
		return null;
	}

	public void prepare() throws Exception {
	}

	/**
	 * 跳转到klgBankManageList.jsp
	 */
	public String knowledgeBankManageList() {
		topFiveTypicalCases = bankManageService.findTopFiveTypicalCases();
		topFiveTypicalViolation = bankManageService
				.findTopFiveTypicalViolations();
		topFiveExperiences = bankManageService.findTopFiveExperiences();
		return "knowledgeBankManageList";
	}

	/**
	 * 跳转到klgBankManageDisp.jsp
	 * 
	 * @return
	 */
	public String knowledgeBankManageDisp() {

		if (klgType != null) {

			if (klgType.equals("tpc")) {
				klgType = "klg_typicalCase";

			} else if (klgType.equals("tpv")) {
				klgType = "klg_typicalViolation";
			} else if (klgType.equals("tpe")) {
				klgType = "klg_experience";
			}

			typeContent = bankManageService.findAllByType(klgType);
		} else {
			System.out.println("重定向klgType出现空值");
		}
		return "knowledgeBankManageDisp";
	}

	/**
	 * 跳转到knowledgeBankUploadDisp.jsp
	 */
	public String knowledgeBankUploadDisp() {

		return "knowledgeBankUploadDisp";
	}

	/**
	 * 知识上传
	 * 
	 */
	public String upload() {
		Sys_User user = (Sys_User) ActionContext.getContext().getSession().get(
				"user");
		userId = user.getId();
		if (klgType != null) {
			String klg;

			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-mm-dd");
			String dates = simpleDateFormat.format(date);

			if (klgType.equals("tpc")) {
				klg = "klg_typicalCase";
				String path = "";
				if (caseImg != null && caseImg.size() > 0) {
					path = bankManageService.upLoadTpc(klg, caseImg,
							caseImgFileName, userId);
				}
				bankManageService.upLoadTypeCase(klg, title, content, path,
						dates);

			} else if (klgType.equals("tpv")) {
				klg = "klg_typicalViolation";

				if (title.equals("bea")) {
					title = "行为违章";
				} else if (title.equals("equ")) {
					title = "装置违章";
				} else if (title.equals("man")) {
					title = "管理违章";
				}

				String[] con = content.split("\\d+.\\s*");

				for (int i = 1; i < con.length; i++) {
					bankManageService.upLoadKlg(klg, title, dates, con[i],
							userId);
				}
			} else if (klgType.equals("tpe")) {
				klg = "klg_experience";
				bankManageService.upLoadKlg(klg, title, dates, content, userId);
			}
		}

		return "toDisp";
	}

	/**
	 * 跳转到编辑知识页面
	 */
	public String klgEditUi() {

		// 根据知识id获取响应知识
		typeContent = bankManageService.findContenById(klgId, klgType);
		Iterator<Object[]> iterator = typeContent.iterator();
		if (klgType.equals("klg_typicalCase")) {

			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				title = objects[1].toString();
				content = objects[3].toString();
				if (objects[7] == null) {
					pic = new String[0];
				} else {
					type = objects[7].toString();
					pic = type.split("#");
				}

			}
		} else if (klgType.equals("klg_typicalViolation")) {

			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				title = objects[1].toString();
				content = objects[3].toString();
				type = objects[6].toString();
			}
		} else if (klgType.equals("klg_experience")) {
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				title = objects[1].toString();
				content = objects[3].toString();
				type = objects[2].toString();
			}
		}

		return "editUi";
	}

	/**
	 * 编辑知识
	 */
	public String klgUpdate() {
		// 日期设置
		String updateTime = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		updateTime = dateFormat.format(date);

		String checkTime;
		if (klgType.equals("klg_typicalCase")
				|| klgType.equals("klg_typicalViolation")) {
			bankManageService.updateKlg(klgId, klgType, updateTime, title,
					content, type);
		} else if (klgType.equals("klg_experience")) {
			Experience experience = bankManageService.findExpById(klgId);
			experience.setContent(title);
			experience.setExplaination(content);
			experience.setStatement(type);
			bankManageService.upDateExp(experience);
		}
		return "toList";
	}

	/**
	 * 删除某条知识
	 */
	public String klgDelete() {
		if (klgType != null) {
			bankManageService.deleteKle(klgType, klgId);
		}
		return "toList";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public File getKndFile() {
		return kndFile;
	}

	public void setKndFile(File kndFile) {
		this.kndFile = kndFile;
	}

	public String getKndFileFileName() {
		return kndFileFileName;
	}

	public void setKndFileFileName(String kndFileFileName) {
		this.kndFileFileName = kndFileFileName;
	}

	public List<TypicalCase> getTopFiveTypicalCases() {
		return topFiveTypicalCases;
	}

	public void setTopFiveTypicalCases(List<TypicalCase> topFiveTypicalCases) {
		this.topFiveTypicalCases = topFiveTypicalCases;
	}

	public List<TypicalViolation> getTopFiveTypicalViolation() {
		return topFiveTypicalViolation;
	}

	public void setTopFiveTypicalViolation(
			List<TypicalViolation> topFiveTypicalViolation) {
		this.topFiveTypicalViolation = topFiveTypicalViolation;
	}

	public List<Experience> getTopFiveExperiences() {
		return topFiveExperiences;
	}

	public void setTopFiveExperiences(List<Experience> topFiveExperiences) {
		this.topFiveExperiences = topFiveExperiences;
	}

	public String getKlgType() {
		return klgType;
	}

	public void setKlgType(String klgType) {
		this.klgType = klgType;
	}

	public List<TypicalCase> getTypicalCases() {
		return typicalCases;
	}

	public void setTypicalCases(List<TypicalCase> typicalCases) {
		this.typicalCases = typicalCases;
	}

	public List<TypicalViolation> getTypicalViolations() {
		return typicalViolations;
	}

	public void setTypicalViolations(List<TypicalViolation> typicalViolations) {
		this.typicalViolations = typicalViolations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Object[]> getTypeContent() {
		return typeContent;
	}

	public void setTypeContent(List<Object[]> typeContent) {
		this.typeContent = typeContent;
	}

	public long getKlgId() {
		return klgId;
	}

	public void setKlgId(long klgId) {
		this.klgId = klgId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<File> getCaseImg() {
		return caseImg;
	}

	public void setCaseImg(List<File> caseImg) {
		this.caseImg = caseImg;
	}

	public List<String> getCaseImgFileName() {
		return caseImgFileName;
	}

	public void setCaseImgFileName(List<String> caseImgFileName) {
		this.caseImgFileName = caseImgFileName;
	}

	public String[] getPic() {
		return pic;
	}

	public void setPic(String[] pic) {
		this.pic = pic;
	}

}
