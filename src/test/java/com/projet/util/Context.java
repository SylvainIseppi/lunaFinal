package com.projet.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
	static ClassPathXmlApplicationContext context=null;
	private static ClassPathXmlApplicationContext context() {
		return new ClassPathXmlApplicationContext("application-Context.xml");
	}
	
	public static ClassPathXmlApplicationContext getInstance() {
        if (null == context) {
            context =context();
        }
        return context;
    }
}
