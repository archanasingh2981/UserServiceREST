package com.data.store;



import java.util.List;

import org.hibernate.Query;

//

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.User;  
  
public class UserStore {  
	
	private static Configuration cfg;
	private static SessionFactory factory;
	
	static {
		 //creating configuration object  
	    cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    
	    //creating seession factory object  
	     factory=cfg.buildSessionFactory();  
	    
	}
	


public static String  insertUser(com.bean.User user){
	Session session = factory.openSession();
	
	Transaction transaction = session.beginTransaction();
	user.setUserId(); // we are setting the userId to be return back to the User, its not same as the PK field ID
	
	session.save(user);//persisting the object  
	
    transaction.commit();//transaction is committed  
    session.close();  
        
    System.out.println("User is successfully saved.");
    return user.getUserId();
	
    	
}

public static User findUser(String userId){
	User user = null;
	
	Session session = factory.openSession();
	
	Query query =session.createQuery("from com.bean.User where userId="+userId);  
	
	List list = query.getResultList();
	
	if(!list.isEmpty()){
	 user = (User)list.get(0);
	}
	 
	 return user;
	
}



}  


