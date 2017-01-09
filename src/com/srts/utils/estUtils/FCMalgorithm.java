package com.srts.utils.estUtils;

import java.util.ArrayList;
import java.util.List;

public class FCMalgorithm {
	public FCMalgorithm(){}
	public String FCMfunction(int[] point,List<int[]> cores,double[] weight)
	{
		//因为m通常取[1.5,2.5],为了让计算简化令m=2
		String resString="";
		int dimension=point.length;
		int categories=cores.size();
		List<Double> uijList=new ArrayList<Double>();
		for(int i=0;i<categories;i++)
		{
			double dij=0;
			double dkj=0;
			double uij=0;
			double uijtemp=0;
			for(int k=0;k<dimension;k++)
			{
				dij+=(point[k]-cores.get(i)[k])*(point[k]-cores.get(i)[k])*weight[k]*weight[k];
			}
			for(int j=0;j<categories;j++)
			{
				for(int k=0;k<dimension;k++)
				{
					dkj+=(point[k]-cores.get(j)[k])*(point[k]-cores.get(j)[k])*weight[k]*weight[k];
				}
				uijtemp+=dij/dkj;
			}
			uij=1/uijtemp;
			uijList.add(uij);
		}
		double temp=0;
		int tag=0;
		for(int t=0;t<uijList.size();t++)
		{
			if(temp<uijList.get(t))
			{
				temp=uijList.get(t);
				tag=t;
			}
		}
		resString=String.valueOf(tag);
		return resString;
	}

}
