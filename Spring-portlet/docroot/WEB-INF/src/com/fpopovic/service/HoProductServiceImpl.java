package com.fpopovic.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpopovic.dao.HoProductRepository;
import com.fpopovic.model.HoProduct;

@Service
@Transactional
public class HoProductServiceImpl implements HoProductService {
	
	@Autowired
	private HoProductRepository repository;
	
	public HoProductRepository getRepository() {
		return repository;
	}

	@Override
	public List<HoProduct> getAllproducts() {

		return repository.findAll();
	}

	@Override
	public HoProduct findProductById(Long id) {

		return repository.findOne(id);
	}

}
