package com.fpopovic.service;

import java.util.List;

import com.fpopovic.model.HoProduct;

public interface HoProductService {
	
	public List<HoProduct> getAllproducts();
	public HoProduct findProductById(Long id);
}
