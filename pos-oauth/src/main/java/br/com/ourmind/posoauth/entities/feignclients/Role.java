package br.com.ourmind.posoauth.entities.feignclients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	
	private Long id;
	
	private String roleName;
	
}
