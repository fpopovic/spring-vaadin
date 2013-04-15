package com.fpopovic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpopovic.dao.HoInvoiceRepository;
import com.fpopovic.model.HoInvoice;
@Service
@Transactional
public class HoInvoiceServiceImpl implements HoInvoiceService {
	
	@Autowired
	private HoInvoiceRepository repository;

	public HoInvoiceRepository getRepository() {
		return repository;
	}

	@Override
	public List<HoInvoice> getAllInvoices() {

		return repository.findAll();
	}

	@Override
	public HoInvoice findInvoiceById(Long id) {

		return repository.findOne(id);
	}

}
