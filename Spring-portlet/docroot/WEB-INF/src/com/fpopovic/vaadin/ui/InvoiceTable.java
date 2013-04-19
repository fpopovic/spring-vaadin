package com.fpopovic.vaadin.ui;

import java.util.List;

import com.fpopovic.model.HoInvoice;
import com.fpopovic.vaadin.SpringApplication;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Table;

/**
 * @author fp
 * Not in the spring scope
 * Invoices table (list all invoices in db )
 */
public class InvoiceTable extends Table {

	private static final long serialVersionUID = 2037494583263913656L;
	private SpringApplication springApp;
	private InvoiceContainer beanContainer = new InvoiceContainer();
/**
 * Constructor in charge of table creation and data population 
 */
public InvoiceTable(List<HoInvoice> listOfInvoices,SpringApplication springApp) {
	this.springApp = springApp;

	beanContainer.addAll(listOfInvoices);
 	this.setContainerDataSource(beanContainer);
 	this.setVisibleColumns(InvoiceContainer.VISIBLE);
 	this.setColumnHeaders(InvoiceContainer.COL_HEADERS);
	this.setCaption("Hyperoptic Invoices");
	this.setPageLength(listOfInvoices.size());
	this.addListener((ItemClickListener)springApp);
	this.setSelectable(true);
	this.setImmediate(true);
}


public SpringApplication getSpringApp() {
	return springApp;
}
}
