package com.example.controle_estoque.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.controle_estoque.model.ProdutoModel;
import com.example.controle_estoque.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new ProdutoModel());
        return "produtos/form";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute ProdutoModel produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            return "produtos/form";
        }
        return "redirect:/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return "redirect:/produtos";
    }
}