package com.srts.examination.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.TestInfo;

@Controller
@Scope("prototype")
public class TestInfoManAction extends BaseActionImpl<TestInfo> {
	private static final long serialVersionUID = 1L;

	public TestInfo getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
