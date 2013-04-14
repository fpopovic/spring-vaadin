package com.fpopovic.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ho_invoice database table.
 * 
 */
@Entity
@Table(name="ho_invoice")
public class HoInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long invoiceId;

	private Double invoiceAmount;

	@Column(nullable=false)
	private Timestamp invoiceDate;

	private Double invoiceNumber;

	private Double taxAmount;

	@Temporal(TemporalType.DATE)
	private Date toBePaidDate;

	//bi-directional many-to-one association to HoCompany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_Id", nullable=false)
	private HoCompany hoCompany;

	//bi-directional many-to-one association to HoCustomer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerId", nullable=false)
	private HoCustomer hoCustomer;

	//bi-directional many-to-one association to HoInvoicerow
	@OneToMany(mappedBy="hoInvoice", cascade={CascadeType.ALL})
	private List<HoInvoicerow> hoInvoicerows;

	public HoInvoice() {
	}

	public Long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Double getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Timestamp getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Double getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(Double invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Double getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Date getToBePaidDate() {
		return this.toBePaidDate;
	}

	public void setToBePaidDate(Date toBePaidDate) {
		this.toBePaidDate = toBePaidDate;
	}

	public HoCompany getHoCompany() {
		return this.hoCompany;
	}

	public void setHoCompany(HoCompany hoCompany) {
		this.hoCompany = hoCompany;
	}

	public HoCustomer getHoCustomer() {
		return this.hoCustomer;
	}

	public void setHoCustomer(HoCustomer hoCustomer) {
		this.hoCustomer = hoCustomer;
	}

	public List<HoInvoicerow> getHoInvoicerows() {
		return this.hoInvoicerows;
	}

	public void setHoInvoicerows(List<HoInvoicerow> hoInvoicerows) {
		this.hoInvoicerows = hoInvoicerows;
	}

}