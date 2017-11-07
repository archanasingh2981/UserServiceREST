package com.user.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.bean.LoginLink;
import com.bean.User;
import com.data.store.LoginLinkStore;
import com.data.store.UserStore;

@Path("/userservice")
public class UserService {
	
	private static String SERVER_NAME = "USRVC.COM";
	private static String SERVER_SOCKET_STRING = "https://";
	private static String  SERVICE = "/userservice";
	private static String LOGIN_LINK_URL= "/login";
	
	@Path("newuser/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public static String register(
			User user) throws JSONException{
		
		String userId = UserStore.insertUser(user);
		if (userId == null){
			return "An error occured while saving the error , please try again later";
		}
		JSONObject response  = new JSONObject();
		response.put("userid",userId);
		return response.toString();
		
	}
	
	
	@Path("/getuser")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static String getUser(@QueryParam("userId") String userId){
		User user;
		
		user = UserStore.findUser(userId);
		
		if(user== null) {return "USER is not found, please check the user id provided";}
		LoginLink  loginLink =  new LoginLink(user.getUserId(), SERVER_SOCKET_STRING+SERVER_NAME+SERVICE+LOGIN_LINK_URL+"?userId="+userId);
		loginLink.setUserEmail(user.getEmail());
		LoginLinkStore.addLink(loginLink);
		
		EmailService emailService = new EmailService();
		emailService.setLoginLink(loginLink);
		emailService.sendEmail();
		
		return "User Id found, please check your registered email for details";
	}
	
	
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public static String getLoginDetails(@QueryParam("userId") String userId) throws JSONException{
		
		//check if the link is valid 
		if(LoginLinkService.isLinkValid(LoginLinkStore.findLoginLink(userId))){
		User user = UserStore.findUser(userId);
		if(user!= null){
			JSONObject response  = new JSONObject();
			response.put("user",user);
			return response.toString();
		}
		else return "Error: something went wrong, we are checking it";
		}
		else return "Error : Something went wrong, looks like the link was expired.";
		
	}
	

}
