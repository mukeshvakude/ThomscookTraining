package com.customtag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			 out.print(Calendar.getInstance().getTime());//printing date and time using JspWriter 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SKIP_BODY;
	}

	
}
