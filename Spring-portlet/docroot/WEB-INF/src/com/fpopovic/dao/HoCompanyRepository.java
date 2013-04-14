package com.fpopovic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fpopovic.model.HoCompany;

@Repository
public interface HoCompanyRepository extends JpaSpecificationExecutor<HoCompany>,JpaRepository<HoCompany, Long>{

}
