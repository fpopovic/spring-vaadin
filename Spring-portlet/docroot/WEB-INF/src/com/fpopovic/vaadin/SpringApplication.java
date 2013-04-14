package com.fpopovic.vaadin;

import org.dellroad.stuff.vaadin.SpringContextApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.fpopovic.model.HoCompany;
import com.fpopovic.service.HoCompanyService;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;



public class SpringApplication extends SpringContextApplication {

	private static final long serialVersionUID = -6075745650709838482L;
	@Autowired
	HoCompanyService service;
	
	public void initialize() {
		Window window = new Window();

		setMainWindow(window);

		Label label = new Label("Hello Spring!");

		window.addComponent(label);
		HoCompany hc = service.findCompanyById(1l);
		
		window.addComponent(new Label("HC name: "+hc.getCompanyName()));
		window.addComponent(new Label("HC address: "+hc.getCompanyAddress()));

	}

	@Override
	protected void initSpringApplication(ConfigurableWebApplicationContext arg0) {
		
		initialize();
	}

}