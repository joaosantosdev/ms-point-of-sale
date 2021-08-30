package br.com.ourmind.posproductmovement.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.ourmind.posproductmovement.dto.MovementDTO;
import br.com.ourmind.posproductmovement.dto.ProductDTO;
import br.com.ourmind.posproductmovement.entities.Movement;
import br.com.ourmind.posproductmovement.enums.TypeOperationEnum;
import br.com.ourmind.posproductmovement.errors.RestException;
import br.com.ourmind.posproductmovement.repositories.MovementRepository;

@Service
public class MovementProductService {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private MovementRepository repository;

	public void createMovementOutputProduct(List<MovementDTO> listMovementDTO) {
		this.userService.validateClients(listMovementDTO);

		List<ProductDTO> products = this.productService.getProductsByListMovement(listMovementDTO);

		List<Movement> movements = listMovementDTO.stream().map(item -> item.toEntity()).collect(Collectors.toList());

		movements = this.addDiscountOrPoints(movements, products);

		this.repository.saveAll(movements);
	}

	public void createMovementInputProduct(List<MovementDTO> listMovementDTO) {
		List<ProductDTO> products = this.productService.getProductsByListMovement(listMovementDTO);

		List<Movement> movements = listMovementDTO.stream().map(item -> {

			ProductDTO product = products.stream().filter(p -> p.getId().equals(item.getProductId()))
					.collect(Collectors.toList()).get(0);

			Movement movement = item.toEntity();
			movement.setTypeOperation(TypeOperationEnum.INPUT.getId());

			this.validateQuantityProduct(product.getId(), movement);

			return movement;
		}).collect(Collectors.toList());

		this.repository.saveAll(movements);
	}

	private void validateQuantityProduct(Long productId, Movement movement) {
		Long quantityTotal = this.repository.getQuantityTotalByProduct(productId);
		if (movement.getQuantity() <= 0) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Product quantity negative");
		} else if ((quantityTotal == null || movement.getQuantity() > quantityTotal)
				&& movement.getTypeOperation().equals(TypeOperationEnum.OUTPUT.getId())) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Quantity unavailable");
		}
	}

	private List<Movement> addDiscountOrPoints(List<Movement> movements, List<ProductDTO> products) {
		return movements.stream().map(item -> {

			ProductDTO product = products.stream().filter(p -> p.getId().equals(item.getProductId()))
					.collect(Collectors.toList()).get(0);

			item.setPointsGenerated(product.getFreebiePoints());
			item.setTypeOperation(TypeOperationEnum.OUTPUT.getId());
			item.setDateCreated(LocalDateTime.now());

			this.validateQuantityProduct(product.getId(), item);

			return item;
		}).collect(Collectors.toList());
	}

}
