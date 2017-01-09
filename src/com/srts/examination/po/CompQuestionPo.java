package com.srts.examination.po;

public class CompQuestionPo {
	private String competitionNo;
	private String compQuestionId;
	private String compQuestionType;
	private String compQuestionContent;
	private String compQuestionPic;
	private String a,b,c,d;
	public CompQuestionPo(){}
	public CompQuestionPo(String competitionNo, String compQuestionId,
			String compQuestionType, String compQuestionContent,
			String compQuestionPic) {
		super();
		this.competitionNo = competitionNo;
		this.compQuestionId = compQuestionId;
		this.compQuestionType = compQuestionType;
		this.compQuestionContent = compQuestionContent;
		this.compQuestionPic = compQuestionPic;
	}
	public String getCompetitionNo() {
		return competitionNo;
	}
	public void setCompetitionNo(String competitionNo) {
		this.competitionNo = competitionNo;
	}
	public String getCompQuestionId() {
		return compQuestionId;
	}
	public void setCompQuestionId(String compQuestionId) {
		this.compQuestionId = compQuestionId;
	}
	public String getCompQuestionType() {
		return compQuestionType;
	}
	public void setCompQuestionType(String compQuestionType) {
		this.compQuestionType = compQuestionType;
	}
	public String getCompQuestionContent() {
		return compQuestionContent;
	}
	public void setCompQuestionContent(String compQuestionContent) {
		
		if(compQuestionType.equals("单选题")){
			int aw=compQuestionContent.indexOf("A");
			int end=compQuestionContent.length();
			this.compQuestionContent=compQuestionContent.substring(0, aw);
			int bw=compQuestionContent.indexOf("B");
			int cw=compQuestionContent.indexOf("C");
			a=compQuestionContent.substring(aw, bw);
			b=compQuestionContent.substring(bw, cw);
			c=compQuestionContent.substring(cw, end);
		}else if(compQuestionType.equals("多选题")){
			int end=compQuestionContent.length();
			int aw=compQuestionContent.indexOf("A");
			int bw=compQuestionContent.indexOf("B");
			int cw=compQuestionContent.indexOf("C");
			int dw=compQuestionContent.indexOf("D");
			a=compQuestionContent.substring(aw, bw);
			b=compQuestionContent.substring(bw, cw);
			c=compQuestionContent.substring(cw, dw);
			d=compQuestionContent.substring(dw, end);
			this.compQuestionContent=compQuestionContent.substring(0, aw);
		}else{
			this.compQuestionContent = compQuestionContent;
		}
	}
	public String getCompQuestionPic() {
		return compQuestionPic;
	}
	public void setCompQuestionPic(String compQuestionPic) {
		this.compQuestionPic = compQuestionPic;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
}
