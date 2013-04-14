package com.fpopovic.service;

import java.util.List;

import com.fpopovic.model.HoCompany;


public interface HoCompanyService {

	
	public List<HoCompany> getAllCompanies();
	public HoCompany findCompanyById(Long id);
}
