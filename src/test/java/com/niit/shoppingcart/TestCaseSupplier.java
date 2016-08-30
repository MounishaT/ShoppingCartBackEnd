package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class TestCaseSupplier {
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
/*
	@Test
	public void supplierAddTestCase()
	{
		supplier.setId("PRO_002");
		supplier.setName("dell");
		supplier.setAddress("zxcvb");
		
		assertEquals(supplierDAO.save(supplier),true);
	}*/
	
	@Test
	public void getProductTestCase(){
		supplier=supplierDAO.get("PRO_002");
		System.out.println(supplier.getName());
		assertEquals(supplier.getName(),"asus");
	}
	@Test
	public void updateTestCase(){
		supplier.setId("PRO_002");
		supplier.setName("asus");
		supplier.setAddress("sdfghj");
		assertEquals(supplierDAO.update(supplier),true);
	}

}
