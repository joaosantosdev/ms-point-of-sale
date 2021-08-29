package br.com.ourmind.posadministrator.enums;

public enum RoleEnum {
	SALESMAN(1L),
	CLIENT(2L),
	ADMINISTRATOR(3L);

	private Long id;

	RoleEnum(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
}
