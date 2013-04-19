package com.fpopovic.service;

import java.util.List;

import com.fpopovic.model.HoCustomer;

public interface HoCustomerService {
	
	public List<HoCustomer> getAllCompanies();
	public HoCustomer findCompanyById(Long id);
	public boolean saveCustomerByNameAddressPhoneEmail(String name,String address,String phone,String email);
}
