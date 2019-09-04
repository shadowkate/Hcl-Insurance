package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Policy;

@Repository
public interface PolicyDetailsRepository extends JpaRepository<Policy, Integer> {

}
