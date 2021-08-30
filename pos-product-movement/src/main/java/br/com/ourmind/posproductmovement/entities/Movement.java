package br.com.ourmind.posproductmovement.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movement_product")
public class Movement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long productId;
	
	private LocalDateTime dateCreated;
	
	private Integer typeOperation;
	
	private Double discount;
	
	private Long pointsGenerated;
	
	private Long quantity;
	
	private Long salesmanId;

}
