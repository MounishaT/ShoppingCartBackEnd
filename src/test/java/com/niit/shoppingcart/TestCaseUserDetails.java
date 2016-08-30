package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {

	
	
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDetailsDAO = (UserDetailsDAO)context.getBean("userDetailsDAO");
		userDetails = (UserDetails)context.getBean("userDetails");
	}
	/*
	@Test
	public void userDetailsAddTestCase()
	{
		userDetails.setId("PRO_001");
		userDetails.setName("blackberry");
		userDetails.setPassword("nisha");
		userDetails.setMail("nisha@gmail.com");
		userDetails.setContact("0987654321");
		userDetails.setAddress("abcd");
	
		assertEquals(userDetailsDAO.save(userDetails),true);
	}/*
/*	
@Test
	public void getuserDetailsTestCase(){
		userDetails=userDetailsDAO.get("PRO_007");
		System.out.println(userDetails.getId());
		assertEquals(userDetails.getName(),"apple");
	}*/

@Test
public void updateTestCase()
{
	userDetails.setId("PRO_001");
	userDetails.setName("abhdk");
	userDetails.setPassword("renu77");
	userDetails.setMail("asus@gmail.com");
	userDetails.setContact("0987654320");
	userDetails.setAddress("abcdsdf");
	
	assertEquals(userDetailsDAO.update(userDetails),true);
}
	
}
