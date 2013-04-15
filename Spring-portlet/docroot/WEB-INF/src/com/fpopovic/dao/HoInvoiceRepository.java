package com.fpopovic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fpopovic.model.HoInvoice;

@Repository
public interface HoInvoiceRepository extends JpaSpecificationExecutor<HoInvoice>,JpaRepository<HoInvoice, Long>{

}
