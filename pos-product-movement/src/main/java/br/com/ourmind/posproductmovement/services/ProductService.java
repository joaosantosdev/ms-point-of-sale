package br.com.ourmind.posproductmovement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ourmind.posproductmovement.dto.MovementDTO;
import br.com.ourmind.posproductmovement.dto.ProductDTO;
import br.com.ourmind.posproductmovement.errors.RestException;
import br.com.ourmind.posproductmovement.feignclients.AdministratorFeignClient;

@Service
public class ProductService {

	@Autowired
	private AdministratorFeignClient administratorFeignClient;

	public List<ProductDTO> getProductsByListMovement(List<MovementDTO> listMovementDTO) {
		List<Long> productsIds = listMovementDTO.stream().map(item -> item.getProductId()).collect(Collectors.toList());
		ResponseEntity<List<ProductDTO>> responseProducts = this.administratorFeignClient.getProductsByIds(productsIds);

		if (!HttpStatus.OK.equals(responseProducts.getStatusCode())) {
			throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error");
		}
		List<ProductDTO> products = responseProducts.getBody();
		if (productsIds.size() != products.size()) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Product not found");
		}
		return products;
	}

}
