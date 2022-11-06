package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership dao from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setLevel("Platinum");
		myAccount.setName("An");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the accountdao's getter/setter method 
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		theAccountDAO.setName("An");
		theAccountDAO.setServiceCode("123");
		
		// call the membership dao
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}
}
