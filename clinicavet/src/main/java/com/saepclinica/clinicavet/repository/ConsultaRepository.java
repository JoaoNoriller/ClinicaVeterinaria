package com.saepclinica.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saepclinica.clinicavet.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
