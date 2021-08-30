package br.com.ourmind.posproductmovement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ourmind.posproductmovement.entities.Movement;

@Repository
public interface MovementRepository  extends JpaRepository<Movement, Long>{

	@Query(value = "SELECT quantity_total FROM view_quantity_total_product WHERE product_id = :id ", nativeQuery = true)
	Long getQuantityTotalByProduct(Long id);
}
