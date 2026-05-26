package com.saepclinica.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saepclinica.clinicavet.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

    Veterinario findByLogin(String login);
    
}
