package org.example.atividade1.controller;

import jakarta.transaction.Transactional;
import org.example.atividade1.repository.ProdutoRepository;
import org.example.atividade1.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/form")
    public String form(Produto produto) {
        return "/produto/form";
    }

    @GetMapping("/list")
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("produtos", repository.listarProdutos());
        return new ModelAndView("produto/list");
    }

    @PostMapping("/cadastro")
    public ModelAndView cadastro(Produto produto) {
        repository.save(produto);
        return new ModelAndView("redirect:list");
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.buscarProduto(id));
        return new ModelAndView("produto/form", model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }
}
