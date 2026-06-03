package com.saepclinica.clinicavet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saepclinica.clinicavet.model.Veterinario;
import com.saepclinica.clinicavet.repository.VeterinarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String ProcessamentoLogin(@RequestParam String login, @RequestParam String senha, HttpSession sessao,
            Model model) {

        Veterinario ven = veterinarioRepository.findByLogin(login);

        if (ven != null && ven.getSenha().equals(senha)) {
            sessao.setAttribute("veterinario", ven);
            return "redirect:/principal";
        }

        model.addAttribute("erro", "login ou senha incorretos!");
        return "login";
        
    }

}
