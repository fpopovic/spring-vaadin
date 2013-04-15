package com.fpopovic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fpopovic.model.HoCustomer;

@Repository
public interface HoCustomerRepository extends JpaSpecificationExecutor<HoCustomer>,JpaRepository<HoCustomer, Long>{

}
