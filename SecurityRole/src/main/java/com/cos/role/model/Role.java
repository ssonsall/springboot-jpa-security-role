package com.cos.role.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Role {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String role;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<UserRole> users;
	
	public Role (int id, String roleName) {
		this.id = id;
		this.role = roleName;
	}	
}
