package com.thiago.petshop.repositories;

import com.thiago.petshop.domain.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {

}
