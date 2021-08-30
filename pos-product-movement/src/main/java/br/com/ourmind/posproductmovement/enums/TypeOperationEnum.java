package br.com.ourmind.posproductmovement.enums;

public enum TypeOperationEnum {

	OUTPUT(1), INPUT(2);

	private Integer id;

	TypeOperationEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

}
