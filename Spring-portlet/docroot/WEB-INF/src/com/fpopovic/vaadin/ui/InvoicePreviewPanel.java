package com.fpopovic.vaadin.ui;

import java.util.List;

import com.fpopovic.model.HoCompany;
import com.fpopovic.model.HoCustomer;
import com.fpopovic.model.HoInvoice;
import com.fpopovic.model.HoInvoicerow;
import com.fpopovic.vaadin.SpringApplication;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class InvoicePreviewPanel extends Panel {

	private static final long serialVersionUID = -2692848486808324266L;
	private VerticalLayout rows = new VerticalLayout();
	private SpringApplication springApp;
	
	private Label companyName = new Label();
	private Label companyAddress = new Label();
	private Label companyPhone = new Label();
	private Label companyEmail = new Label();
	
	private Label customerName = new Label();
	private Label customerAddress = new Label();
	private Label customerPhone = new Label();
	private Label customerEmail = new Label();
	
	private Label invoiceNo = new Label();
	private Label invoiceAmount = new Label();
	private Label invoiceVat = new Label();
	private Label invoiceDate = new Label();
	private Label invoiceToBe = new Label();
	
	
	public InvoicePreviewPanel(SpringApplication springApp,HoInvoice invoice) {
		this.springApp = springApp;
		this.setCaption("Invoice preview");
		this.setImmediate(true);
		this.setUpData(invoice);
		this.addComponent(header());
		this.addComponent(rows);
		this.addComponent(footer());
		
	}
	public void setUpData(HoInvoice invoice){
		invoice.getInvoiceId();
		HoCompany comp = invoice.getHoCompany();
		HoCustomer cust = invoice.getHoCustomer();
		List<HoInvoicerow> listIr = invoice.getHoInvoicerows();
		
		companyName.setValue(comp.getCompanyName());
		companyAddress.setValue(comp.getCompanyAddress());
		companyPhone.setValue(comp.getCompanyPhone());
		companyEmail.setValue(comp.getCompanyEmail());
		
		customerName.setValue(cust.getCustomerName()); 
		customerAddress.setValue(cust.getCustomerAddress());
		customerPhone.setValue(cust.getCustomerPhone());
		customerEmail.setValue(cust.getCustomerEmail());
		
		invoiceAmount.setValue(invoice.getInvoiceAmount());
		invoiceVat.setValue(invoice.getTaxAmount());
		invoiceDate.setValue(invoice.getInvoiceDate());
		invoiceNo.setValue(invoice.getInvoiceNumber());
		invoiceToBe.setValue(invoice.getToBePaidDate());
		
		content(listIr);
		
	}
	public GridLayout header(){
		GridLayout grid = new GridLayout(2,2);
		
		grid.addComponent(companyData(), 0, 1);		
		grid.addComponent(customerData(), 1, 1);
		
		return grid;
	}
	public VerticalLayout content(List<HoInvoicerow> rowList){
		for (HoInvoicerow hoInvoicerow : rowList) {
			rows.addComponent(new InvoiceRowPreview(hoInvoicerow.getHoProduct().getProductName()
					, hoInvoicerow.getNumberOfProducts(), hoInvoicerow.getRowTaxAmount(), hoInvoicerow.getRowAmount()));
		}
		return rows;
	}
	public GridLayout footer(){
		GridLayout grid = new GridLayout(2,2);
		grid.addComponent(new Label("Vat sum: "), 0, 0);
		grid.addComponent(new Label("Amount sum: "), 0, 1);
		grid.addComponent(invoiceVat, 1, 0);
		grid.addComponent(invoiceAmount, 1, 1);
		return grid;
	}
	public VerticalLayout getRows() {
		return rows;
	}
	public VerticalLayout companyData(){
		VerticalLayout vertical = new VerticalLayout();
		vertical.addComponent(companyName);
		vertical.addComponent(companyAddress);
		vertical.addComponent(companyPhone);
		vertical.addComponent(companyEmail);
		
		return vertical;
	}
	public VerticalLayout customerData(){
		VerticalLayout vertical = new VerticalLayout();
		vertical.addComponent(customerName);
		vertical.addComponent(customerAddress);
		vertical.addComponent(customerPhone);
		vertical.addComponent(customerEmail);
		
		return vertical;
	}
	
	public void setRows(VerticalLayout rows) {
		this.rows = rows;
	}
	
}
