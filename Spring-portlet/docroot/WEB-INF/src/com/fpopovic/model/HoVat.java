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
 * The persistent class for the ho_vat database table.
 * 
 */
@Entity
@Table(name="ho_vat")
public class HoVat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long vatId;

	private Float vatPercentage;

	@Column(length=100)
	private String vatType;

	//bi-directional many-to-one association to HoInvoicerow
	@OneToMany(mappedBy="hoVat")
	private List<HoInvoicerow> hoInvoicerows;

	public HoVat() {
	}

	public Long getVatId() {
		return this.vatId;
	}

	public void setVatId(Long vatId) {
		this.vatId = vatId;
	}

	public Float getVatPercentage() {
		return this.vatPercentage;
	}

	public void setVatPercentage(Float vatPercentage) {
		this.vatPercentage = vatPercentage;
	}

	public String getVatType() {
		return this.vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public List<HoInvoicerow> getHoInvoicerows() {
		return this.hoInvoicerows;
	}

	public void setHoInvoicerows(List<HoInvoicerow> hoInvoicerows) {
		this.hoInvoicerows = hoInvoicerows;
	}

}