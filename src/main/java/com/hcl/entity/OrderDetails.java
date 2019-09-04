package com.hcl.entity;

import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Getter
@Setter
@Entity
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String name;
	private String email;
	private int sapId;
	private LocalDate date;
	private String policyFor;
	private String dependentName;
	private int policyId;
	private int policyNumber;

}
