package com.srts.estimation.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.WorkerWholeEstimateDao;
import com.srts.estimation.service.WorkerWholeEstimateService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.estUtils.FCMalgorithm;

@Service
public class WorkerWholeEstimateServiceImpl implements
		WorkerWholeEstimateService {
	@Resource
	private WorkerWholeEstimateDao workerWholeEstimateDao;

	public int setTrainTestEstMark(Sys_User usr) {
		int mark=0;
		int mark1=100;
		int mark2=100;
		int mark3=100;
		int pass=0;
		List<String[]> res1=workerWholeEstimateDao.findUserTestScoreByUserAndType(usr, "正式");
		List<String[]> res2=workerWholeEstimateDao.findUserTestScoreStability(usr, "正式");
		for(int i=0;i<res1.size();i++)
		{
			if(Integer.parseInt(res1.get(i)[1])>=90)
			{
				pass++;
				if(100>=Integer.parseInt(res1.get(i)[1])&&Integer.parseInt(res1.get(i)[1])>95)
				{
					
				}
				else if(95>=Integer.parseInt(res1.get(i)[1])&&Integer.parseInt(res1.get(i)[1])>=90)
				{
					mark1=mark1-1;
				}
				else if(Integer.parseInt(res1.get(i)[1])<90)
				{
					mark1=mark1-3;
				}
			}
		}
		double passRate=0;
		if(res1.size()!=0)
		{
		    passRate=(double)(pass/res1.size());
		}
		else
		{
			passRate=0;
		}
		if(passRate==1)
		{
			mark2=100;
		}
		else if(1>passRate&&passRate>=0.95)
		{
			mark2=(int)(100*passRate);
		}
		else if(0.95>passRate&&passRate>=0.92)
		{
			mark2=(int)(100-((0.95-passRate)/0.03)*15);
		}
		else if(0.92>passRate&&passRate>=0.90)
		{
			mark2=(int)(85-((0.92-passRate)/0.02)*5);
		}
		else if(0.90>passRate&&passRate>=0.85)
		{
			mark2=(int)(80-((0.9-passRate)/0.05)*10);
		}
		else
		{
			mark2=70;
		}
		if(Double.parseDouble(res2.get(0)[1])>=0.05)
		{
			mark3=70;
		}
		else if(Double.parseDouble(res2.get(0)[1])<0.05&&Double.parseDouble(res2.get(0)[1])>=0.03)
		{
			mark3=(int)(97-((Double.parseDouble(res2.get(0)[1])-0.03)/0.02)*17);
		}
		else if(Double.parseDouble(res2.get(0)[1])<0.03&&Double.parseDouble(res2.get(0)[1])>=0.02)
		{
			mark3=(int)(100-(Double.parseDouble(res2.get(0)[1]))*100);
		}
		else
		{
			mark3=100;
		}
		int[] point={mark1,mark2,mark3};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100,100};
		int[] core1={95,95,95};
		int[] core2={90,80,80};
		int[] core3={90,80,70};
		int[] core4={80,80,70};
		int[] core5={80,70,70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.6,0.3,0.1};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			mark=100;
		}
		else if(resString.equals("1"))
		{
			mark=95;
		}
		else if(resString.equals("2"))
		{
			mark=90;
		}
		else if(resString.equals("3"))
		{
			mark=80;
		}
		else if(resString.equals("4"))
		{
			mark=70;
		}
		else if(resString.equals("5"))
		{
			mark=60;
		}
		return mark;
	}

	public int setMockTestEstMark(Sys_User usr) {
		int mark=0;
		int mark1=100;
		int mark2=100;
		int mark3=100;
		int pass=0;
		List<String[]> res1=workerWholeEstimateDao.findUserTestScoreByUserAndType(usr, "模拟");
		List<String[]> res2=workerWholeEstimateDao.findUserTestScoreStability(usr, "模拟");
		for(int i=0;i<res1.size();i++)
		{
			if(Integer.parseInt(res1.get(i)[1])>=90)
			{
				pass++;
				if(100>=Integer.parseInt(res1.get(i)[1])&&Integer.parseInt(res1.get(i)[1])>95)
				{
					
				}
				else if(95>=Integer.parseInt(res1.get(i)[1])&&Integer.parseInt(res1.get(i)[1])>=90)
				{
					mark1=mark1-1;
				}
				else if(Integer.parseInt(res1.get(i)[1])<90)
				{
					mark1=mark1-3;
				}
			}
		}
		double passRate=0;
		if(res1.size()!=0)
		{
		    passRate=(double)(pass/res1.size());
		}
		else
		{
			passRate=0;
		}
		if(passRate==1)
		{
			mark2=100;
		}
		else if(1>passRate&&passRate>=0.95)
		{
			mark2=(int)(100*passRate);
		}
		else if(0.95>passRate&&passRate>=0.92)
		{
			mark2=(int)(100-((0.95-passRate)/0.03)*15);
		}
		else if(0.92>passRate&&passRate>=0.90)
		{
			mark2=(int)(85-((0.92-passRate)/0.02)*5);
		}
		else if(0.90>passRate&&passRate>=0.85)
		{
			mark2=(int)(80-((0.9-passRate)/0.05)*10);
		}
		else
		{
			mark2=70;
		}
		if(Double.parseDouble(res2.get(0)[1])>=0.05)
		{
			mark3=70;
		}
		else if(Double.parseDouble(res2.get(0)[1])<0.05&&Double.parseDouble(res2.get(0)[1])>=0.03)
		{
			mark3=(int)(97-((Double.parseDouble(res2.get(0)[1])-0.03)/0.02)*17);
		}
		else if(Double.parseDouble(res2.get(0)[1])<0.03&&Double.parseDouble(res2.get(0)[1])>=0.02)
		{
			mark3=(int)(100-(Double.parseDouble(res2.get(0)[1]))*100);
		}
		else
		{
			mark3=100;
		}
		int[] point={mark1,mark2,mark3};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100,100};
		int[] core1={95,95,95};
		int[] core2={90,80,80};
		int[] core3={90,80,70};
		int[] core4={80,80,70};
		int[] core5={80,70,70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.6,0.3,0.1};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			mark=100;
		}
		else if(resString.equals("1"))
		{
			mark=95;
		}
		else if(resString.equals("2"))
		{
			mark=90;
		}
		else if(resString.equals("3"))
		{
			mark=80;
		}
		else if(resString.equals("4"))
		{
			mark=70;
		}
		else if(resString.equals("5"))
		{
			mark=60;
		}
		return mark;
	}

	public int setCmncEstMark(Sys_User usr) {
		List<String[]> res1=workerWholeEstimateDao.selectWorkerProCmncAcp(usr);
		List<String[]> res2=workerWholeEstimateDao.selectWorkerProCmncAmount(usr);
		List<String[]> res3=workerWholeEstimateDao.selectWorkerStuCmncAmount(usr);
		int mark=0;
		int mark1=100;
		int mark2=100;
		int mark3=100;
		if(Integer.parseInt((res1.get(0)[0]))>100)
		{
			
		}
		else if(Integer.parseInt((res1.get(0)[0]))<=100&&Integer.parseInt((res1.get(0)[0]))>50)
		{
			mark1=mark1-5;
		}
		else
		{
			mark1=mark1-10;
		}
		double acpRate=0;
		if(Integer.parseInt((res1.get(0)[0]))==0)
		{
			
		}
		else
		{
		    acpRate=(Double.parseDouble((res1.get(1)[0]))/Double.parseDouble((res1.get(0)[0])));
		}
		if(acpRate>0.5)
		{
			
		}
		else if(acpRate<=0.5&&acpRate>0.3)
		{
			mark1=(int)(mark1-((0.5-acpRate)/0.2)*10);
		}
		else if(acpRate<=0.3&&acpRate>0.1)
		{
			mark1=(int)(mark1-((0.3-acpRate)/0.2)*10);
		}
		else
		{
			mark1=mark1-30;
		}
		if(Integer.parseInt(res2.get(0)[0])>30)
		{
			
		}
		else if(Integer.parseInt(res2.get(0)[0])>10&&Integer.parseInt(res2.get(0)[0])<=30)
		{
			mark2=mark2-(30-Integer.parseInt(res2.get(0)[0]));
		}
		else
		{
			mark2=70;
		}
		if(Integer.parseInt(res3.get(0)[0])>20)
		{
			
		}
		else if(Integer.parseInt(res3.get(0)[0])<=20&&Integer.parseInt(res3.get(0)[0])>10)
		{
			mark3=mark3-(20-Integer.parseInt(res3.get(0)[0]))/2;
		}
		else
		{
			mark3=mark3-20;
		}
		if(Integer.parseInt(res3.get(0)[0])>50)
		{
			
		}
		else if(Integer.parseInt(res3.get(0)[0])<=50&&Integer.parseInt(res3.get(0)[0])>10)
		{
			mark3=mark3-(50-Integer.parseInt(res3.get(0)[0]))/4;
		}
		else
		{
			mark3=mark3-20;
		}
		int[] point={mark1,mark2,mark3};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100,100};
		int[] core1={90,90,90};
		int[] core2={90,80,80};
		int[] core3={80,80,80};
		int[] core4={80,80,70};
		int[] core5={70,80,60};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.8,0.1,0.1};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			mark=100;
		}
		else if(resString.equals("1"))
		{
			mark=95;
		}
		else if(resString.equals("2"))
		{
			mark=90;
		}
		else if(resString.equals("3"))
		{
			mark=80;
		}
		else if(resString.equals("4"))
		{
			mark=70;
		}
		else if(resString.equals("5"))
		{
			mark=60;
		}
		return mark;
	}

	public int setExerciseEstMark(Sys_User usr) {
		List<String[]> res1=workerWholeEstimateDao.getExerciseAccuracyRateToNow(usr);
		List<String[]> res2=workerWholeEstimateDao.getExerciseAmountToNow(usr);
		int mark=0;
		int mark1=100;
		int mark2=100;
		int passAmount=0;
		for(int i=0;i<res1.size();i++)
		{
			if(Double.parseDouble(res1.get(i)[1])>=0.9)
			{
				passAmount++;
			}
		}
		double passRate=0;
		if(res1.size()!=0)
		{
		    passRate=(double)(passAmount/res1.size());
		}
		else
		{
			passRate=0;
		}
		if(passRate==1)
		{
			
		}
		else if(passRate<1&&passRate>=0.95)
		{
			mark1=(int)(mark1-((1-passRate)/0.05)*5);
		}
		else if(passRate<0.95&&passRate>=0.9)
		{
			mark1=(int)(95-((0.95-passRate)/0.05)*10);
		}
		else if(passRate<0.9&&passRate>=0.8)
		{
			mark1=(int)(85-((0.9-passRate)/0.1)*15);
		}
		else
		{
			mark1=70;
		}
		if(res1.size()<10)
		{
			mark1=mark1-5;
		}
		if(Integer.parseInt(res2.get(0)[0])>20)
		{
			
		}
		else if(Integer.parseInt(res2.get(0)[0])<=20&&Integer.parseInt(res2.get(0)[0])>10)
		{
			mark2=mark2-(20-Integer.parseInt(res2.get(0)[0]));
		}
		else if(Integer.parseInt(res2.get(0)[0])<=10)
		{
			mark2=85;
		}
		if(Double.parseDouble(res2.get(0)[1])>20)
		{
			
		}
		else if(Double.parseDouble(res2.get(0)[1])<=20&&Double.parseDouble(res2.get(0)[1])>10)
		{
			mark2=(int)(mark2-(20-Double.parseDouble(res2.get(0)[1])));
		}
		else if(Double.parseDouble(res2.get(0)[1])<=10)
		{
			mark2=mark2-15;
		}
		int[] point={mark1,mark2};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100};
		int[] core1={100,90};
		int[] core2={95,80};
		int[] core3={85,80};
		int[] core4={85,70};
		int[] core5={70,70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.6,0.4};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			mark=100;
		}
		else if(resString.equals("1"))
		{
			mark=95;
		}
		else if(resString.equals("2"))
		{
			mark=90;
		}
		else if(resString.equals("3"))
		{
			mark=80;
		}
		else if(resString.equals("4"))
		{
			mark=70;
		}
		else if(resString.equals("5"))
		{
			mark=60;
		}
		return mark;
	}

	public int setStudyEstMark(Sys_User usr) throws ParseException {
		int mark=0;
		int mark1=100;
		double sum=0;
		double minSum=10000000;
		double maxSum=0;
		List<String[]> res1=workerWholeEstimateDao.getAveStudySumTimeToNow(usr);
		for(int i=0;i<res1.size();i++)
		{
			sum+=Double.parseDouble(res1.get(i)[1]);
			if(minSum>Double.parseDouble(res1.get(i)[1]))
			{
				minSum=Double.parseDouble(res1.get(i)[1]);
			}
			if(maxSum<Double.parseDouble(res1.get(i)[1]))
			{
				maxSum=Double.parseDouble(res1.get(i)[1]);
			}
		}
		double aveTime=sum/res1.size();
		double gap=maxSum-minSum;
		if(aveTime>60)
		{
			
		}
		else if(aveTime<=60&&aveTime>30)
		{
			mark1=(int)(mark1-(60-aveTime)/3);
		}
		else if(aveTime<=30&&aveTime>10)
		{
			mark1=(int)(90-(30-aveTime)/2);
		}
		else
		{
			mark1=70;
		}
		if(gap>1000)
		{
			mark1=mark1-5;
		}
		if(res1.size()<5)
		{
			mark1=mark1-5;
		}
		int[] point={mark1};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100};
		int[] core1={95};
		int[] core2={90};
		int[] core3={85};
		int[] core4={80};
		int[] core5={70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={1};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			mark=100;
		}
		else if(resString.equals("1"))
		{
			mark=95;
		}
		else if(resString.equals("2"))
		{
			mark=90;
		}
		else if(resString.equals("3"))
		{
			mark=80;
		}
		else if(resString.equals("4"))
		{
			mark=70;
		}
		else if(resString.equals("5"))
		{
			mark=60;
		}
		return mark;
	}

	public int setKlgBankEstMark(Sys_User usr) {
		List<String[]> res1=workerWholeEstimateDao.workerKlgSearchEst(usr);
		List<String[]> res2=workerWholeEstimateDao.workerOpExpUpload(usr);
		int mark=0;
		int mark1=100;
		int mark2=100;
		for(int i=0;i<res1.size();i++)
		{
			if(Integer.parseInt(res1.get(i)[0])>50)
			{
				
			}
			else if(Integer.parseInt(res1.get(i)[0])<=50&&Integer.parseInt(res1.get(i)[0])>30)
			{
				mark1=mark1-(50-Integer.parseInt(res1.get(i)[0]))/8;
			}
			else if(Integer.parseInt(res1.get(i)[0])<=30&&Integer.parseInt(res1.get(i)[0])>10)
			{
				mark1=mark1-2-(30-Integer.parseInt(res1.get(i)[0]))/8;
			}
			else if(Integer.parseInt(res1.get(i)[0])<=10&&Integer.parseInt(res1.get(i)[0])>5)
			{
				mark1=mark1-5-(10-Integer.parseInt(res1.get(i)[0]))/4;
			}
			else
			{
				mark1=mark1-7;
			}
		}
		int allOpUploadNum=Integer.parseInt(res2.get(0)[0])+Integer.parseInt(res2.get(1)[0]);
		if(allOpUploadNum>50)
		{
			
		}
		else if(allOpUploadNum<=50&&allOpUploadNum>30)
		{
			mark2=mark2-(50-allOpUploadNum)/2;
		}
		else if(allOpUploadNum<=30&&allOpUploadNum>10)
		{
			mark2=90-(30-allOpUploadNum)/2;
		}
		else
		{
			mark2=70;
		}
		int[] point={mark1,mark2};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100};
		int[] core1={90,100};
		int[] core2={90,90};
		int[] core3={90,80};
		int[] core4={80,90};
		int[] core5={70,70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.8,0.2};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			mark=100;
		}
		else if(resString.equals("1"))
		{
			mark=95;
		}
		else if(resString.equals("2"))
		{
			mark=90;
		}
		else if(resString.equals("3"))
		{
			mark=80;
		}
		else if(resString.equals("4"))
		{
			mark=70;
		}
		else if(resString.equals("5"))
		{
			mark=60;
		}
		return mark;
	}

}
