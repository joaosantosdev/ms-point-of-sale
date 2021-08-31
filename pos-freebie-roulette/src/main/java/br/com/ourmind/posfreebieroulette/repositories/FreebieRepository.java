package br.com.ourmind.posfreebieroulette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ourmind.posfreebieroulette.entities.Freebie;

@Repository
public interface FreebieRepository extends JpaRepository<Freebie, Long> {

}
