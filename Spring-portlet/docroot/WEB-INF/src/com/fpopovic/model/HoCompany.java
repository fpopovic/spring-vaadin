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
 * The persistent class for the ho_company database table.
 * 
 */
@Entity
@Table(name="ho_company")
public class HoCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long company_Id;

	@Column(length=255)
	private String companyAddress;

	@Column(length=150)
	private String companyEmail;

	@Column(length=150)
	private String companyName;

	@Column(length=150)
	private String companyPhone;

	//bi-directional many-to-one association to HoInvoice
	@OneToMany(mappedBy="hoCompany")
	private List<HoInvoice> hoInvoices;

	public HoCompany() {
	}

	public Long getCompany_Id() {
		return this.company_Id;
	}

	public void setCompany_Id(Long company_Id) {
		this.company_Id = company_Id;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyEmail() {
		return this.companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public List<HoInvoice> getHoInvoices() {
		return this.hoInvoices;
	}

	public void setHoInvoices(List<HoInvoice> hoInvoices) {
		this.hoInvoices = hoInvoices;
	}

}