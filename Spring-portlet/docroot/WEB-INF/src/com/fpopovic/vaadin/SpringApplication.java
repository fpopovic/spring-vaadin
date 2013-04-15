package com.fpopovic.vaadin;

import java.util.List;

import org.dellroad.stuff.vaadin.SpringContextApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.fpopovic.model.HoCompany;
import com.fpopovic.model.HoInvoice;
import com.fpopovic.model.HoInvoicerow;
import com.fpopovic.service.HoCompanyService;
import com.fpopovic.service.HoInvoiceService;
import com.fpopovic.vaadin.ui.InvoiceTable;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;



/**
 * @author fp
 * In the spring scope
 */
public class SpringApplication extends SpringContextApplication {

	private static final long serialVersionUID = -6075745650709838482L;
	@Autowired
	HoCompanyService service;
	@Autowired
	HoInvoiceService invoiceService;
	
	public void initialize() {
		Window window = new Window();

		setMainWindow(window);

		Label label = new Label("Hello Spring!");

		window.addComponent(label);
		HoCompany hc = service.findCompanyById(1l);
		List<HoInvoice> listOfInvoices = invoiceService.getAllInvoices();
		for (HoInvoice hoInvoice : listOfInvoices) {
			window.addComponent(new Label("InvId: "+hoInvoice.getInvoiceId()));
			window.addComponent(new Label("InvAmount: "+hoInvoice.getInvoiceAmount()));
			window.addComponent(new Label("InvNumber: "+hoInvoice.getInvoiceNumber()));
			window.addComponent(new Label("InvDate: "+hoInvoice.getInvoiceDate()));
			window.addComponent(new Label("InvCompId: "+hoInvoice.getHoCompany().getCompany_Id()));
			window.addComponent(new Label("InvCustId: "+hoInvoice.getHoCustomer().getCustomerId()));
			List<HoInvoicerow> listRow = hoInvoice.getHoInvoicerows();
			for (HoInvoicerow hoInvoicerow : listRow) {
				window.addComponent(new Label("Row: "+hoInvoicerow.getRowAmount()));
			}
		}
		 
		window.addComponent(new Label("HC name: "+hc.getCompanyName()));
		window.addComponent(new Label("HC address: "+hc.getCompanyAddress()));
		window.addComponent(new Label("HC Phone: "+hc.getCompanyPhone()));
		InvoiceTable invoiceTable = new InvoiceTable(invoiceService.getAllInvoices());
		window.addComponent(invoiceTable);
		
	}

	@Override
	protected void initSpringApplication(ConfigurableWebApplicationContext arg0) {
		
		initialize();
	}

}