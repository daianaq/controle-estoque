package com.example.controle_estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controle_estoque.model.ProdutoModel;
import com.example.controle_estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel salvarProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}