package com.cos.role.myenum;

public enum RoleType {
	USER(1),MANAGER(2),ADMIN(3),TESTER(4);
	
	final public int ID;
	
	private RoleType(int id) {
		this.ID = id;
	}
}
