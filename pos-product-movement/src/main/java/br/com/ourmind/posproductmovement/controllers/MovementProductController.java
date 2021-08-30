package br.com.ourmind.posproductmovement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ourmind.posproductmovement.dto.MovementDTO;
import br.com.ourmind.posproductmovement.services.MovementProductService;

@RestController
@RequestMapping(value = "/movements")
public class MovementProductController {

	@Autowired
	private MovementProductService service;

	@PostMapping(value = "/output")
	public ResponseEntity<Void> createMovementOutputProduct(@RequestBody List<MovementDTO> listMovementDTO) {
		this.service.createMovementOutputProduct(listMovementDTO);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/input")
	public ResponseEntity<Void> createMovementInputProduct(@RequestBody List<MovementDTO> listMovementDTO) {
		this.service.createMovementInputProduct(listMovementDTO);
		return ResponseEntity.noContent().build();
	}

}
