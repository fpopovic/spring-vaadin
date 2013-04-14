package com.fpopovic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the ho_invoicerow database table.
 * 
 */
@Entity
@Table(name="ho_invoicerow")
public class HoInvoicerow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long invoiceRowId;

	private Long numberOfProducts;

	private Double rowAmount;

	private Double rowTaxAmount;

	//bi-directional many-to-one association to HoInvoice
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="invoiceId", nullable=false)
	private HoInvoice hoInvoice;

	//bi-directional many-to-one association to HoProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productId", nullable=false)
	private HoProduct hoProduct;

	//bi-directional many-to-one association to HoVat
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vatId", nullable=false)
	private HoVat hoVat;

	public HoInvoicerow() {
	}

	public Long getInvoiceRowId() {
		return this.invoiceRowId;
	}

	public void setInvoiceRowId(Long invoiceRowId) {
		this.invoiceRowId = invoiceRowId;
	}

	public Long getNumberOfProducts() {
		return this.numberOfProducts;
	}

	public void setNumberOfProducts(Long numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public Double getRowAmount() {
		return this.rowAmount;
	}

	public void setRowAmount(Double rowAmount) {
		this.rowAmount = rowAmount;
	}

	public Double getRowTaxAmount() {
		return this.rowTaxAmount;
	}

	public void setRowTaxAmount(Double rowTaxAmount) {
		this.rowTaxAmount = rowTaxAmount;
	}

	public HoInvoice getHoInvoice() {
		return this.hoInvoice;
	}

	public void setHoInvoice(HoInvoice hoInvoice) {
		this.hoInvoice = hoInvoice;
	}

	public HoProduct getHoProduct() {
		return this.hoProduct;
	}

	public void setHoProduct(HoProduct hoProduct) {
		this.hoProduct = hoProduct;
	}

	public HoVat getHoVat() {
		return this.hoVat;
	}

	public void setHoVat(HoVat hoVat) {
		this.hoVat = hoVat;
	}

}