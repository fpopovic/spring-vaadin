package com.fpopovic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fpopovic.model.HoProduct;

@Repository
public interface HoProductRepository extends JpaSpecificationExecutor<HoProduct>,JpaRepository<HoProduct, Long>{

}
