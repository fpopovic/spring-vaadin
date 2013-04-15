package com.fpopovic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpopovic.dao.HoInvoicerowRepository;
import com.fpopovic.model.HoInvoicerow;
@Service
@Transactional
public class HoInvoicerowServiceImpl implements HoInvoicerowService {
	
	@Autowired
	private HoInvoicerowRepository repository;
	
	public HoInvoicerowRepository getRepository() {
		return repository;
	}

	@Override
	public List<HoInvoicerow> getAllInvoicerows() {

		return repository.findAll();
	}

	@Override
	public HoInvoicerow findInvoicerowById(Long id) {

		return repository.findOne(id);
	}

}
