package com.giovanni.apisgp.service;

import com.giovanni.apisgp.models.Produto;
import com.giovanni.apisgp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Page<Produto> findAllPageable(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public  Produto findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    public Produto save(Produto produto) {return produtoRepository.save(produto);}
}
