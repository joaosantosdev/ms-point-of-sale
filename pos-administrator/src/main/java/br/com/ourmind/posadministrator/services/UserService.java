package br.com.ourmind.posadministrator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.ourmind.posadministrator.dto.UserDTO;
import br.com.ourmind.posadministrator.entities.User;
import br.com.ourmind.posadministrator.errors.RestException;
import br.com.ourmind.posadministrator.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public boolean isEmailRegistered(String email) {
		return this.repository.findByEmail(email) != null;
	}

	public void save(UserDTO userDTO) {
		if (this.isEmailRegistered(userDTO.getEmail())) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Email registered");
		}
		this.repository.save(userDTO.toEntity());
	}

	public List<UserDTO> getAll() {
		return this.repository.findAll().stream().map(user -> UserDTO.toDTO(user)).collect(Collectors.toList());
	}

	public User getById(Long id) {
		Optional<User> user = this.repository.findById(id);
		if (user.isEmpty()) {
			throw new RestException(HttpStatus.NOT_FOUND, "User not found");
		}
		return user.get();
	}

	public User getByEmail(String email) {
		User user = this.repository.findByEmail(email);
		System.out.println(user.getRole().getRoleName());
		return user;
	}

	public void update(Long id, UserDTO userDTO) {
		User userEmail = this.getByEmail(userDTO.getEmail());

		if (userEmail != null && !userEmail.getId().equals(id)) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Email registered");
		}

		this.getById(id);
		User user = userDTO.toEntity();
		user.setId(id);

		this.repository.save(user);
	}

	public List<UserDTO> findByIdsAndRoleId(List<Long> ids, Long roleId) {
		return this.repository.findByIdInAndRoleId(ids, roleId).stream().map(user -> UserDTO.toDTO(user))
				.collect(Collectors.toList());
	}
}
