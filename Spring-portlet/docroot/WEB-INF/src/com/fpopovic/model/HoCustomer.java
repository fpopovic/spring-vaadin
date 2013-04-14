package com.fpopovic.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ho_customer database table.
 * 
 */
@Entity
@Table(name="ho_customer")
public class HoCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long customerId;

	@Column(length=255)
	private String customerAddress;

	@Column(length=150)
	private String customerEmail;

	@Column(length=150)
	private String customerName;

	@Column(length=150)
	private String customerPhone;

	//bi-directional many-to-one association to HoInvoice
	@OneToMany(mappedBy="hoCustomer")
	private List<HoInvoice> hoInvoices;

	public HoCustomer() {
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public List<HoInvoice> getHoInvoices() {
		return this.hoInvoices;
	}

	public void setHoInvoices(List<HoInvoice> hoInvoices) {
		this.hoInvoices = hoInvoices;
	}

}