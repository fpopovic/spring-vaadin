package com.fpopovic.vaadin.ui;

import com.fpopovic.vaadin.SpringApplication;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickListener;

public class InputWindow extends Window implements ClickListener{

	private static final long serialVersionUID = 6185129240591734214L;
	private Button closeBtn = new Button("Close Window", (ClickListener)this);
	private Button addProduct = new Button("Add Product", (ClickListener)this);
	private Button addCustomer = new Button("Add Customer", (ClickListener)this);
	private Button addVat = new Button("Add Vat", (ClickListener)this);
	private TextField productName = new TextField("Product name: ");
	private TextField productPrice = new TextField("Product price: ");
	private TextField customerName = new TextField("Customer name: ");
	private TextField customerAddress = new TextField("Customer address: ");
	private TextField customerPhone = new TextField("Customer phone: ");
	private TextField customerEmail = new TextField("Customer email: ");
	private TextField vatType = new TextField("Vat type: ");
	private TextField vatPercentage = new TextField("Vat percentage: ");
	private TabSheet tabSheet = new TabSheet();	
	private SpringApplication springApp;
	/**
	 * Constructor- child window for invoice parameters initialization 
	 */
	public InputWindow(SpringApplication springApp) {
		this.springApp = springApp;
		this.setCaption("Invoice input parameters ");
		this.setHeight("600px");	
		this.setWidth("500px");
		this.center();
		this.addComponent(tabSheet);
		this.addComponent(closeBtn);
		setUpTabSheet();
	}
	public SpringApplication getSpringApp() {
		return springApp;
	}
	public void setUpTabSheet(){
		tabSheet.addComponent(addNewProduct());
		tabSheet.addComponent(addNewCustomer());
		tabSheet.addComponent(addNewVat());
	}
	public FormLayout addNewProduct(){
		FormLayout form = new FormLayout();
		productName.addValidator(new RegexpValidator("[\\w]{3,99}", "Must contain minimum 3 characters"));
		productPrice.addValidator(new RegexpValidator("[0-9]+(.[0-9]{1,2})", "Number with two decimal places"));
		form.setCaption("New Product");
		form.addComponent(productName);
		form.addComponent(productPrice);
		form.addComponent(addProduct);
		
		return form;
	}
	public FormLayout addNewCustomer(){
		FormLayout form = new FormLayout();
		customerName.addValidator(new RegexpValidator("[\\w]{4,99}", "Must contain characters between 4 and 100"));
		customerAddress.addValidator(new RegexpValidator("[\\w]{4,99}", "Must contain characters between 4 and 100"));
		customerPhone.addValidator(new RegexpValidator("[\\w]{4,99}", "Must contain characters between 4 and 100"));
		customerEmail.addValidator(new RegexpValidator("[\\w]{4,50}+(@)+(.[\\w]){4,50}", "Enter valid email"));
		form.setCaption("New Customer");
		form.addComponent(customerName);
		form.addComponent(customerAddress);
		form.addComponent(customerPhone);
		form.addComponent(customerEmail);
		form.addComponent(addCustomer);
		
		return form;
	}
	public FormLayout addNewVat(){
		FormLayout form = new FormLayout();
		vatType.addValidator(new RegexpValidator("[\\w]{4,99}", "Must contain characters between 4 and 100"));
		vatType.setRequired(true);
		vatPercentage.addValidator(new RegexpValidator("[0-9]+(.[0-9]{1,2})", "Must be decimal number with two decimal points"));
		form.setCaption("New Vat");
		form.addComponent(vatType);
		form.addComponent(vatPercentage);
		form.addComponent(addVat);

		return form;
	}
	/* 
	 * Button event that interacts with db inputs in forms
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();
		if(source == closeBtn){
			//close window
			close();
		}else if(source == addProduct){
			//Input new product in db
			if(productName.isValid()&&productPrice.isValid()){
				String pn = (String) productName.getValue();
				String pprice = (String)productPrice.getValue();
				Double pp = Double.parseDouble(pprice);
				boolean flag = springApp.getProductService().saveByNameAndPrice(pn, pp);
				productName.setValue("");
				productPrice.setValue("");
				if(flag){
					getWindow().showNotification("Success !");
				}else{
					getWindow().showNotification("Something went wrong !");
				}
			}
		}else if(source == addCustomer){
			//input customer in db
			String cn = (String)customerName.getValue();
			String ca = (String)customerAddress.getValue();
			String cp = (String)customerPhone.getValue();
			String ce = (String)customerEmail.getValue();
			boolean flag = springApp.getCustomerService().saveCustomerByNameAddressPhoneEmail(cn, ca, cp, ce);
			customerName.setValue("");
			customerAddress.setValue("");
			customerPhone.setValue("");
			customerEmail.setValue("");
				if(flag){
					getWindow().showNotification("Success !");
				}else{
					getWindow().showNotification("Something went wrong !");
				}
		}else if(source == addVat){
			//add new vat in db
			if(vatType.isValid()&&vatPercentage.isValid()){
				String vt = (String)vatType.getValue();
				String perc = (String)vatPercentage.getValue();
				Float vp = Float.parseFloat(perc);
				springApp.getVatService().saveVatByParams(vt, vp);
			
			}else{
				getWindow().showNotification("Something went wrong !");
				
			}
		}
	}
}
