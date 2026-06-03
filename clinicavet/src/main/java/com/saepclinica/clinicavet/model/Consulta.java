package com.saepclinica.clinicavet.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    private  Veterinario veterinario;

    private String nome;
    private String raca;
    private String genero;
    private String dono;
    private LocalDate dataconsulta;
    private int vetquantidade;
    private String procedimento;

    public Long getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaça() {
        return raca;
    }
    public void setRaça(String raça) {
        this.raca = raça;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public LocalDate getDataconsulta() {
        return dataconsulta;
    }
    public void setDataconsulta(LocalDate dataconsulta) {
        this.dataconsulta = dataconsulta;
    }
    public int getVetquantidade() {
        return vetquantidade;
    }
    public void setVetquantidade(int vetquantidade) {
        this.vetquantidade = vetquantidade;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

}
