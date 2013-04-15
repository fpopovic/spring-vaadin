package com.fpopovic.service;

import java.util.List;

import com.fpopovic.model.HoInvoice;

public interface HoInvoiceService {
	
	public List<HoInvoice> getAllInvoices();
	public HoInvoice findInvoiceById(Long id);
}
