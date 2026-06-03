package com.saepclinica.clinicavet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saepclinica.clinicavet.model.Animal;
import com.saepclinica.clinicavet.repository.AnimalRepository;
import com.saepclinica.clinicavet.repository.ConsultaRepository;
import com.saepclinica.clinicavet.repository.VeterinarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AnimalController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    // Lista todas as consultas
    @GetMapping("/animais")
    public String listarProdutos(
        HttpSession sassao, 
        Model model, 
        @RequestParam(required = false) String buscaAnimal) {
            
        if (sassao.getAttribute("veterinario") == null)
            return "redirect:/login";

        List<Animal> animal;
        if (buscaAnimal != null && !buscaAnimal.isBlank())
            animal = animalRepository.findByNomeContainingIgnoreCase(buscaAnimal);
        else
            animal = animalRepository.findAll();

        model.addAttribute("animais", animal);

        return "animais/lista";
    }

    // Salva uma consulta nova ou atualiza uma existente
    @PostMapping("/animais/salvar")
    public String salvarConsulta(
            HttpSession sessao,
            @ModelAttribute Animal animal) {

        if (sessao.getAttribute("veterinario") == null)
            return "redirect:/login";

        animalRepository.save(animal);

        return "redirect:/animais";
    }

    @GetMapping("/animais/editar/{id}")
    public String editarProduto(
            HttpSession sessao,
            @PathVariable Long id,
            Model model) {

        if (sessao.getAttribute("veterinario") == null)
            return "redirect:/login";

        Animal animal = animalRepository.findById(id).orElseThrow();
        model.addAttribute("animal", animal);

        return "animais/editar";
    }

    @PostMapping("/animais/deletar/{id}")
    public String deletarProduto(HttpSession sessao, @PathVariable Long id) {

        if (sessao.getAttribute("veterinario") == null)
            return "redirect:/login";

        animalRepository.deleteById(id);

        return "redirect:/animais";
    }

}