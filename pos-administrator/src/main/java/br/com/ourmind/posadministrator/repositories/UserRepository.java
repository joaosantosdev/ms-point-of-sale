package br.com.ourmind.posadministrator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ourmind.posadministrator.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	List<User> findByIdInAndRoleId(List<Long> ids, Long roleId);

}
