package br.com.ourmind.posproductmovement.dto;

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

}
