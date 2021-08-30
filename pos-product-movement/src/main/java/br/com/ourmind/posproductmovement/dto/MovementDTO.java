package br.com.ourmind.posproductmovement.dto;

import br.com.ourmind.posproductmovement.entities.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovementDTO {
	
	private Long id;

	private Long productId;
	
	private Long clientId;

	private Long quantity;	
	
	public Movement toEntity() {
		Movement movement = new Movement();
		movement.setProductId(this.productId);
		movement.setQuantity(this.quantity);
		movement.setProductId(this.productId);
		return movement;
	}

}
