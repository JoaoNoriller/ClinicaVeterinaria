package com.saepclinica.clinicavet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saepclinica.clinicavet.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByNomeContainingIgnoreCase(String nome);
}
