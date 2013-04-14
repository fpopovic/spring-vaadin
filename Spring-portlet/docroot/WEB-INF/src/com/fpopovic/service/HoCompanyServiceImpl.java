package com.fpopovic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpopovic.dao.HoCompanyRepository;
import com.fpopovic.model.HoCompany;

@Service
@Transactional
public class HoCompanyServiceImpl implements HoCompanyService{
	@Autowired
	private HoCompanyRepository hoCompanyRepository;
	
	@Override
	public List<HoCompany> getAllCompanies() {
		return hoCompanyRepository.findAll();
		
	}

	@Override
	public HoCompany findCompanyById(Long id) {
		
		return hoCompanyRepository.findOne(id);
	}

}
