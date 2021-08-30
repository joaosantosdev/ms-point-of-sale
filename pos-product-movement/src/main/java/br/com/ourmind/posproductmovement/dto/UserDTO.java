package br.com.ourmind.posproductmovement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Long roleId;

}
