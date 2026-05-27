package com.saepclinica.clinicavet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saepclinica.clinicavet.model.Consulta;
import com.saepclinica.clinicavet.repository.AnimalRepository;
import com.saepclinica.clinicavet.repository.ConsultaRepository;
import com.saepclinica.clinicavet.repository.VeterinarioRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    // Lista todas as consultas, com busca opcional pelo nome do animal
    @GetMapping("/consultas")
    public String listarConsultas(
            HttpSession sessao,
            Model model,
            @RequestParam(required = false) String buscaConsulta) {

        if (sessao.getAttribute("veterinario") == null)
            return "redirect:/login";

        List<Consulta> consultas;
        if (buscaConsulta != null && !buscaConsulta.isBlank())
            consultas = consultaRepository.findByNomeContainingIgnoreCase(buscaConsulta);
        else
            consultas = consultaRepository.findAll();

        // Envia as listas de animais e veterinários para popular os selects do formulário
        model.addAttribute("consultas", consultas);
        model.addAttribute("animais", animalRepository.findAll());
        model.addAttribute("veterinarios", veterinarioRepository.findAll());
        model.addAttribute("novaConsulta", new Consulta());

        return "consultas/lista";
    }

    // Salva uma consulta nova ou atualiza uma existente
    @PostMapping("/consultas/salvar")
    public String salvarConsulta(
            HttpSession sessao,
            @ModelAttribute Consulta consulta) {

        if (sessao.getAttribute("veterinario") == null)
            return "redirect:/login";

        consultaRepository.save(consulta);

        return "redirect:/consultas";
    }
}