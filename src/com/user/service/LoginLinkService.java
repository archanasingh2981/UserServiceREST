package com.user.service;

import java.util.Calendar;

import com.bean.LoginLink;

public class LoginLinkService {
	
	public static final int MAX_MINUTES= 15;
	
	
	public static boolean isLinkValid(LoginLink loginLink){
		System.out.println("1:- "+loginLink.getExpiry().getTimeInMillis());
		System.out.println("2: -"+Calendar.getInstance().getTimeInMillis());
		if(loginLink.getExpiry().getTimeInMillis()<Calendar.getInstance().getTimeInMillis()) return false;
		else return true;
	}

}
