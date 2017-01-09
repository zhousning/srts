package com.srts.knowledge.domain;

public class KnowledgeChain {
	private long id;
	private TypicalCase typicalCase;
	private TypicalViolation typicalViolation;
	private Experience experience;
	private RuleLearning ruleLearning;
	private String explaination;
	private long searchnum;
	public KnowledgeChain(){}
	public KnowledgeChain(long id, TypicalCase typicalCase,
			TypicalViolation typicalViolation, Experience experience,
			RuleLearning ruleLearning, String explaination, long searchnum) {
		this.id = id;
		this.typicalCase = typicalCase;
		this.typicalViolation = typicalViolation;
		this.experience = experience;
		this.ruleLearning = ruleLearning;
		this.explaination = explaination;
		this.searchnum = searchnum;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TypicalCase getTypicalCase() {
		return typicalCase;
	}
	public void setTypicalCase(TypicalCase typicalCase) {
		this.typicalCase = typicalCase;
	}
	public TypicalViolation getTypicalViolation() {
		return typicalViolation;
	}
	public void setTypicalViolation(TypicalViolation typicalViolation) {
		this.typicalViolation = typicalViolation;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	public RuleLearning getRuleLearning() {
		return ruleLearning;
	}
	public void setRuleLearning(RuleLearning ruleLearning) {
		this.ruleLearning = ruleLearning;
	}
	public String getExplaination() {
		return explaination;
	}
	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}
	public long getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(long searchnum) {
		this.searchnum = searchnum;
	}
	
}