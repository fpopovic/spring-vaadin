package com.fpopovic.vaadin;

import java.util.List;

import org.dellroad.stuff.vaadin.SpringContextApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.fpopovic.model.HoInvoice;
import com.fpopovic.service.HoCompanyService;
import com.fpopovic.service.HoCustomerService;
import com.fpopovic.service.HoInvoiceService;
import com.fpopovic.service.HoInvoicerowService;
import com.fpopovic.service.HoProductService;
import com.fpopovic.service.HoVatService;
import com.fpopovic.vaadin.ui.InvoicePreviewPanel;
import com.fpopovic.vaadin.ui.InvoiceTable;
import com.fpopovic.vaadin.ui.InvoiceTableContainer;
import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;



/**
 * @author fp
 * In the spring scope
 */
public class SpringApplication extends SpringContextApplication implements ItemClickListener{

	private static final long serialVersionUID = -6075745650709838482L;
	

	private final VerticalLayout verticalLayout = new VerticalLayout();
	private final HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
	private final Window window = new Window();
	private InvoicePreviewPanel preview;
	private InvoiceTable table = null;
	private InvoiceTableContainer invoiceTableContainer;
	
	@Autowired
	private HoCompanyService companyService;
	@Autowired
	private HoInvoiceService invoiceService;
	@Autowired
	private HoVatService vatService;
	@Autowired
	private HoProductService productService;
	@Autowired
	private HoCustomerService customerService;
	@Autowired
	private HoInvoicerowService invoicerowService;
	private List<HoInvoice> listOfAllInvoices;
	
	/**
	 * Main initialization method
	 */
	public void initialize() {
		//Initialize and set main window 
		setMainWindow(window);
		//Add vertical layout - main window layout
		window.addComponent(verticalLayout);
		verticalLayout.setHeight("800px");
		verticalLayout.addComponent(horizontalSplit);
		//List<HoInvoice> listOfAllInvoices = invoiceService.getAllInvoices();
		
		table = new InvoiceTable(getListOfAllInvoices(),this);
		invoiceTableContainer = new InvoiceTableContainer(table,this);
		setPreview(new InvoicePreviewPanel(this, getListOfAllInvoices().get(0)));
		horizontalSplit.setFirstComponent(invoiceTableContainer);
		horizontalSplit.setSecondComponent(getPreview());
		horizontalSplit.setSplitPosition(40);
				
	}


	/* 
	 * Spring style initialization 
	 * @see org.dellroad.stuff.vaadin.SpringContextApplication#initSpringApplication(org.springframework.web.context.ConfigurableWebApplicationContext)
	 */
	@Override
	protected void initSpringApplication(ConfigurableWebApplicationContext arg0) {
		initialize();
	}

	public HoCompanyService getCompanyService() {
		return companyService;
	}

	public HoInvoiceService getInvoiceService() {
		return invoiceService;
	}

	public HoVatService getVatService() {
		return vatService;
	}

	public HoProductService getProductService() {
		return productService;
	}

	public HoCustomerService getCustomerService() {
		return customerService;
	}

	public HoInvoicerowService getInvoicerowService() {
		return invoicerowService;
	}

	public InvoicePreviewPanel getPreview() {
		return preview;
	}

	public List<HoInvoice> getListOfAllInvoices() {
		return invoiceService.getAllInvoices();
	}


	public void setPreview(InvoicePreviewPanel preview) {
		this.preview = preview;
	}


	public HorizontalSplitPanel getHorizontalSplit() {
		return horizontalSplit;
	}

	@Override
	public void itemClick(ItemClickEvent event) {
		Item item = table.getItem(event.getItemId());
		Long invoiceId = (Long)item.getItemProperty("invoiceId").getValue();
		HoInvoice invoice = getInvoiceService().findInvoiceById(invoiceId);
		setPreview(new InvoicePreviewPanel(this, invoice));
		getHorizontalSplit().removeComponent(getPreview());
		getHorizontalSplit().setSecondComponent(getPreview());
	}

}