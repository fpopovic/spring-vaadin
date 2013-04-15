package com.fpopovic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpopovic.dao.HoVatRepository;
import com.fpopovic.model.HoVat;


@Service
@Transactional
public class HoVatServiceImpl implements HoVatService {
	
	@Autowired
	private HoVatRepository repository;
	
	public HoVatRepository getRepository() {
		return repository;
	}

	@Override
	public List<HoVat> getAllVats() {

		return repository.findAll();
	}

	@Override
	public HoVat findVatById(Long id) {

		return repository.findOne(id);
	}

}
