package br.com.ourmind.posadministrator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ourmind.posadministrator.dto.UserDTO;
import br.com.ourmind.posadministrator.enums.RoleEnum;
import br.com.ourmind.posadministrator.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
		this.service.save(userDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(UserDTO.toDTO(this.service.getById(id)));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		this.service.update(id, userDTO);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/search/clients")
	public ResponseEntity<List<UserDTO>> findByIdsAndRoleId(@RequestParam List<Long> ids) {
		return ResponseEntity.ok(this.service.findByIdsAndRoleId(ids, RoleEnum.CLIENT.getId()));
	}

}
