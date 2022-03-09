package com.thiago.petshop.repositories;

import com.thiago.petshop.domain.Categoria;
import com.thiago.petshop.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
