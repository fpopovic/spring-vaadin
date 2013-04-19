package com.fpopovic.service;

import java.util.List;

import com.fpopovic.model.HoVat;

public interface HoVatService {
	
	public List<HoVat> getAllVats();
	public HoVat findVatById(Long id);
	public void saveVatByParams(String vatType,Float percentage);
}
