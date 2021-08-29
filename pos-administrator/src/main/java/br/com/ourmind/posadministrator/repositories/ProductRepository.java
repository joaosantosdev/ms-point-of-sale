package br.com.ourmind.posadministrator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ourmind.posadministrator.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
