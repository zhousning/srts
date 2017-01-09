package com.srts.common.base.impl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 公用的Action
 * 
 * @author 薄小永
 */
public abstract class BaseActionImpl<T> extends ActionSupport implements
		ModelDriven<T>, Preparable {

	private static final long serialVersionUID = 1L;

}
