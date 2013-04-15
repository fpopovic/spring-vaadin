package com.fpopovic.service;

import java.util.List;

import com.fpopovic.model.HoInvoicerow;

public interface HoInvoicerowService {
	
	public List<HoInvoicerow> getAllInvoicerows();
	public HoInvoicerow findInvoicerowById(Long id);
}
