package com.cos.role.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	//한 건이면 기본 Fetch 전략이 EAGER
	//Collection이면 기본  Fetch 전략이 LAZY
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@JsonIgnoreProperties({"users"})
	@ManyToOne
	private Role role;
}
