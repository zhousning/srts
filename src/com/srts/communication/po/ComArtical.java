package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.BBSArtical;
/**
* 类描述：包含分页的动态
* 创建人：vector   
* 创建时间：2014-7-19 下午07:04:38   
* 备注：热门动态和最新动态的的公用类
 */
public class ComArtical {
	private List<BBSArtical> articals;//热门动态
	private int allPageNum;//总页数
	
	public List<BBSArtical> getArticals() {
		return articals;
	}
	public void setArticals(List<BBSArtical> articals) {
		this.articals = articals;
	}
	public int getAllPageNum() {
		return allPageNum;
	}
	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	
}
