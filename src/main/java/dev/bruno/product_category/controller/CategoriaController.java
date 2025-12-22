package dev.bruno.product_category.controller;

import dev.bruno.product_category.entity.Categoria;
import dev.bruno.product_category.entity.Produto;
import dev.bruno.product_category.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody Categoria categoria) {
        categoriaService.criarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return categoriaService.listarCategorias().isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}/produtos")
    public ResponseEntity<List<Produto>> listarProdutosPorCategoria(@PathVariable Long id) {

        try{

            return ResponseEntity.ok(categoriaService.listarProdutosPorCategoria(id));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
