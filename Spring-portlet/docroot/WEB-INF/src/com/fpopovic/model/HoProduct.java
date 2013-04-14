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
 * The persistent class for the ho_product database table.
 * 
 */
@Entity
@Table(name="ho_product")
public class HoProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long productId;

	@Column(length=150)
	private String productName;

	private Double productValue;

	//bi-directional many-to-one association to HoInvoicerow
	@OneToMany(mappedBy="hoProduct")
	private List<HoInvoicerow> hoInvoicerows;

	public HoProduct() {
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductValue() {
		return this.productValue;
	}

	public void setProductValue(Double productValue) {
		this.productValue = productValue;
	}

	public List<HoInvoicerow> getHoInvoicerows() {
		return this.hoInvoicerows;
	}

	public void setHoInvoicerows(List<HoInvoicerow> hoInvoicerows) {
		this.hoInvoicerows = hoInvoicerows;
	}

}