package br.com.ourmind.posadministrator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.ourmind.posadministrator.dto.ProductDTO;
import br.com.ourmind.posadministrator.entities.Product;
import br.com.ourmind.posadministrator.errors.RestException;
import br.com.ourmind.posadministrator.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public void save(ProductDTO productDTO) {
		this.repository.save(productDTO.toEntity());
	}

	public List<ProductDTO> getAll() {
		return this.repository.findAll().stream().map(product -> ProductDTO.toDTO(product))
				.collect(Collectors.toList());
	}

	public Product getById(Long id) {
		Optional<Product> product = this.repository.findById(id);
		if (product.isEmpty()) {
			throw new RestException(HttpStatus.NOT_FOUND, "Product not found");
		}
		return product.get();
	}

	public void update(Long id, ProductDTO productDTO) {
		this.getById(id);
		Product product = productDTO.toEntity();
		product.setId(id);
		this.repository.save(product);
	}

	public List<ProductDTO> getByIds(List<Long> ids) {

		return this.repository.findAllById(ids).stream().map(product -> ProductDTO.toDTO(product))
				.collect(Collectors.toList());

	}

}
