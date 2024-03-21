package org.example.atividade1.controller;

import jakarta.transaction.Transactional;
import org.example.atividade1.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("itemvenda")
public class ItemVendaController {
    @Autowired
    ItemVendaRepository repository;

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("itemvenda", repository.listarItensVenda(id));
        return new ModelAndView(("venda/details"));
    }
}
