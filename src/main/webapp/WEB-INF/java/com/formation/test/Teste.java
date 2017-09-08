package com.formation.test;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import com.formation.daos.EmployeeDAO;
import com.formation.daos.EmployeeDaiImpl;
import com.formation.entity.EmployeeEntity;

import junit.framework.Assert;

public class Teste {
	
	private static ApplicationContext context;
	
	private static EmployeeDAO employeeDAO;
	
	@BeforeClass
	public static void oneTimeSetup(){
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
	}
	
	@Test
	public void testCreateData(){
		int expectedResult = 1;
		EmployeeEntity categorie = new EmployeeEntity("DIMI","POTEAU","d@hotmail.fr");
		employeeDAO.addEmployee(categorie);
		Assert.assertEquals(expectedResult, employeeDAO.getAllEmployees().size());
	}

}
