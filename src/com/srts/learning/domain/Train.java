package com.srts.learning.domain;

import com.srts.information.domain.TrainNotice;

public class Train {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private TrainNotice trainNotice;//对应哪次培训通知
	public Train(){
	}
	public Train(long id, TrainNotice trainNotice) {
		super();
		this.id = id;
		this.trainNotice = trainNotice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TrainNotice getTrainNotice() {
		return trainNotice;
	}
	public void setTrainNotice(TrainNotice trainNotice) {
		this.trainNotice = trainNotice;
	}
}
