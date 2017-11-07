package com.data.store;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

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
	


public static String  insertUser(User user){
	Session session = factory.openSession();
	
	Transaction transaction = session.beginTransaction();
	
	session.save(user);//persisting the object  
	
    
    transaction.commit();//transaction is committed  
    session.close();  
        
    System.out.println("User is successfully saved.");
    return user.getUserId();
	
    	
}

public static User findUser(String userId){
	User user = null;
	
	Session session = factory.openSession();
	
	Query query =session.createQuery("from User where userId=:uid");  
	query.setParameter("uid", userId);
	
	List list = query.getResultList();
	
	if(!list.isEmpty()){
	 user = (User)list.get(0);
	}
	 
	 return user;
	
}



}  


