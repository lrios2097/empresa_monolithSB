package com.springboot.monolito.repository;

import com.springboot.monolito.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> { // empresa y LONG por el tip de dato del ID


}
