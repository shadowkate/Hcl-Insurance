package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.OrderDetails;

public interface CustomerRepository  extends JpaRepository<OrderDetails,Integer>{

}
