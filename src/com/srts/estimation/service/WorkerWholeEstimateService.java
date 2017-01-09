package com.srts.estimation.service;

import java.text.ParseException;

import com.srts.system.domain.Sys_User;

public interface WorkerWholeEstimateService {
	public int setTrainTestEstMark(Sys_User usr);
	public int setMockTestEstMark(Sys_User usr);
	public int setCmncEstMark(Sys_User usr);
	public int setStudyEstMark(Sys_User usr) throws ParseException;
	public int setExerciseEstMark(Sys_User usr);
	public int setKlgBankEstMark(Sys_User usr);

}
