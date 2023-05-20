package org.library.entity;

public abstract class Admin extends Member {

	boolean privilege;

	protected Admin(String name, String id) {
		super(name, id);
//		this.privilege = isAdmin;
//		init();
	}

	protected void init() {
		if (!privilege) {
			return;
		}

		System.out.println();
	}
}
