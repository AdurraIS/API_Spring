package com.giovanni.apisgp.resource;

import com.giovanni.apisgp.models.Produto;
import com.giovanni.apisgp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProducts() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProductById(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }
    @GetMapping("/pageable")
    public ResponseEntity<Page<Produto>> listarTodosPaginado(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(produtoService.findAllPageable(pageable));
    }

    @PostMapping
    public ResponseEntity<Produto> createStudent(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateStudent(@PathVariable Long id, @RequestBody Produto produto) {
        if (produtoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
       produto.setId(id);
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (produtoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
