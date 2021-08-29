package br.com.ourmind.posadministrator.dto;

import br.com.ourmind.posadministrator.entities.Role;
import br.com.ourmind.posadministrator.entities.User;
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

	public User toEntity() {
		User user = new User();
		user.setEmail(this.email);
		user.setName(this.name);
		user.setPassword(this.email);
		Role role = new Role();
		role.setId(this.roleId);
		user.setRole(role);
		return user;
	}
	
	public static UserDTO toDTO(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setRoleId(user.getRole().getId());
		userDto.setId(user.getId());
		return userDto;
	}
}
