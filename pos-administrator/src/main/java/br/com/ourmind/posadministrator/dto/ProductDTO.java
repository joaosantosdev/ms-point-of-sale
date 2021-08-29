package br.com.ourmind.posadministrator.dto;

import br.com.ourmind.posadministrator.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private Long freebiePoints;

	public Product toEntity() {
		Product product = new Product();
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
		product.setFreebiePoints(this.freebiePoints == null ? 0 : this.freebiePoints);
		return product;
	}

	public static ProductDTO toDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		productDTO.setFreebiePoints(product.getFreebiePoints());
		productDTO.setId(product.getId());
		return productDTO;
	}
}
