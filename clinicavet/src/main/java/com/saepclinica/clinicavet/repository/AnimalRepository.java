package com.saepclinica.clinicavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saepclinica.clinicavet.model.Animal;

public interface  AnimalRepository extends JpaRepository<Animal, Long> {
    
}
