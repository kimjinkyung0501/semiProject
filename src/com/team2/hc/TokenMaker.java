package com.team2.hc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenMaker {
	public static String make(HttpServletRequest req) {
	 
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		final Date d = new Date(); 
		  String aa = sdf.format(d);
		System.out.println(aa);
		req.setAttribute("token", aa);
		return aa;
	}
}
