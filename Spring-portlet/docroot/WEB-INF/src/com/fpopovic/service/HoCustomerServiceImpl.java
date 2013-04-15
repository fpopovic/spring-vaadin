package com.fpopovic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpopovic.dao.HoCustomerRepository;
import com.fpopovic.model.HoCustomer;

@Service
@Transactional
public class HoCustomerServiceImpl implements HoCustomerService {
	
	@Autowired
	private HoCustomerRepository repository;
	
	public HoCustomerRepository getRepository() {
		return repository;
	}

	@Override
	public List<HoCustomer> getAllCompanies() {
		
		return repository.findAll();
	}

	@Override
	public HoCustomer findCompanyById(Long id) {
		
		return repository.findOne(id);
	}

}
