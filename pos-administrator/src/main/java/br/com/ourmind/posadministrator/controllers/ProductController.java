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
import org.springframework.web.bind.annotation.RestController;

import br.com.ourmind.posadministrator.dto.ProductDTO;
import br.com.ourmind.posadministrator.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody ProductDTO productDTO) {
		this.service.save(productDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ProductDTO.toDTO(this.service.getById(id)));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		this.service.update(id, productDTO);
		return ResponseEntity.noContent().build();
	}

}
