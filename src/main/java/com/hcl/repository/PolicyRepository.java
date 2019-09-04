package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}
