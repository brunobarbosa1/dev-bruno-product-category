package dev.bruno.product_category.controller;

import dev.bruno.product_category.entity.Produto;
import dev.bruno.product_category.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestParam Long categoriaId, @RequestBody Produto produto){

        try {

            produtoService.criarProduto(produto, categoriaId);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);

        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return produtoService.listarProdutos().isEmpty() ?  ResponseEntity.noContent().build()
                : ResponseEntity.ok(produtoService.listarProdutos());
    }
}
