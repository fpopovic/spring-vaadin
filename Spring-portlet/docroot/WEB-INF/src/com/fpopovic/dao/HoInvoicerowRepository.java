package com.fpopovic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fpopovic.model.HoInvoicerow;

@Repository
public interface HoInvoicerowRepository extends JpaSpecificationExecutor<HoInvoicerow>,JpaRepository<HoInvoicerow, Long>{

}
