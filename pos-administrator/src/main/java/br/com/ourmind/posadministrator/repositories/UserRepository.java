package br.com.ourmind.posadministrator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ourmind.posadministrator.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
}
