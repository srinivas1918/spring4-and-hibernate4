package com.macsof.listener;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;



public class MyContextLoaderListener extends ContextLoaderListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		super.contextInitialized(event);
		
	}

}
