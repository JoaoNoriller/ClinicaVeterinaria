package com.saepclinica.clinicavet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saepclinica.clinicavet.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

    List<Consulta> findByNomeContainingIgnoreCase(String nome);
    
}
