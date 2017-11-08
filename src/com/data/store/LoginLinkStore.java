package com.data.store;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.LoginLink;

public class LoginLinkStore {
	
	private static Configuration cfg;
	private static SessionFactory factory;
	
	static {
		 //creating configuration object  
	    cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    
	    //creating seession factory object  
	     factory=cfg.buildSessionFactory();  
	    
	}
	
	
	public static LoginLink  addLink(LoginLink loginLink){
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		boolean deleted = false;
		if(findLoginLink(loginLink.getUserId()) != null){
			deleted = deleteLoginLink(loginLink.getUserId());
			if(deleted) {
				System.out.println("deleted the link first");
			}
		}
 
		
		// insert the new login link
		loginLink.setExpiry();
		session.save(loginLink);//persisting the object  
	    
	    transaction.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("LoginLink is successfully saved."+loginLink.getUserId());
	    return loginLink;
		
	    	
	}
	
	public static LoginLink findLoginLink(String userId){
		
		LoginLink loginLink = null;
		
		Session session = factory.openSession();
		
		Query query =session.createQuery("from LoginLink where userId=:uid");  
		query.setParameter("uid", "user1");
		
		List list = query.getResultList();
		
		if(!list.isEmpty()){
			System.out.println("found");
		 loginLink = (LoginLink)list.get(0);
		}
		 
		 return loginLink;
				
	}
	
	
	public static boolean deleteLoginLink( String userId){
		boolean deleted  = false;
		
		Session session = factory.openSession();
		
		Query query =session.createQuery("Delete from LoginLink where userId=:uid"); 
		
		query.setParameter("uid", userId);
		Transaction t = session.beginTransaction();
		int status = query.executeUpdate();
		
		t.commit();
		session.close();
		
		if( status >0) {
			deleted = true;
		}
				 
		return deleted;
		
	}
	 
	

}
