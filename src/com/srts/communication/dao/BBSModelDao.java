package com.srts.communication.dao;

import java.util.ArrayList;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.BBSModel;
import com.srts.communication.po.MonthTop;

public interface BBSModelDao extends BaseDao<BBSModel> {

	void updateModelArticalNum(long bbsModelid);


}
