package org.example.atividade1.controller;

import jakarta.transaction.Transactional;
import org.example.atividade1.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {
    @Autowired
    VendaRepository repository;

    @GetMapping("/list")
    public ModelAndView vendas(ModelMap model) {
        model.addAttribute("vendas", repository.listarVendas());
        return new ModelAndView("venda/list");
    }
}
