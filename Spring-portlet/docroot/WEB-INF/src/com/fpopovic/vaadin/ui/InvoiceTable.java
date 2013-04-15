package com.fpopovic.vaadin.ui;

import java.sql.Timestamp;
import java.util.List;

import com.fpopovic.model.HoInvoice;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

/**
 * @author fp
 * Not in the spring scope
 */
public class InvoiceTable extends Table{

	private static final long serialVersionUID = 2037494583263913656L;

	
/**
 * Constructor in charge of table creation and data population 
 */
public InvoiceTable(List<HoInvoice> listOfInvoices) {
	//Define column names and type
	this.addContainerProperty("Customer", String.class, null);
	this.addContainerProperty("Number", Double.class, null);
	this.addContainerProperty("Vat", Double.class, null);
	this.addContainerProperty("Amount", Double.class, null);
	this.addContainerProperty("Date", Timestamp.class, null);
	//Invoices container
	BeanItemContainer<HoInvoice> beanContainer = new BeanItemContainer<HoInvoice>(HoInvoice.class);
 	for (HoInvoice hoInvoice : listOfInvoices) {
		beanContainer.addBean(hoInvoice);
		this.addItem(new Object[]{	hoInvoice.getHoCustomer().getCustomerName(),
									hoInvoice.getInvoiceNumber(),
									hoInvoice.getTaxAmount(),
									hoInvoice.getInvoiceAmount(),
									hoInvoice.getInvoiceDate()}
											, hoInvoice.getInvoiceId());
	}
	this.setCaption("Hyperoptic Invoices");
	this.setPageLength(listOfInvoices.size());
	this.setSelectable(true);
	this.setImmediate(true);
}
}
