package br.com.ourmind.posproductmovement.entities.feignclients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Long id;

	private String name;

	private String description;

	private Double price;

	private Long freebiePoints;

}
