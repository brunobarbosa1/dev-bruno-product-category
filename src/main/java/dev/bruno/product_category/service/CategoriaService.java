package dev.bruno.product_category.service;

import dev.bruno.product_category.entity.Categoria;
import dev.bruno.product_category.entity.Produto;
import dev.bruno.product_category.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void criarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public List<Produto> listarProdutosPorCategoria(Long idCategoria) {
        return categoriaRepository.findById(idCategoria)
                .map(c -> {
                    return c.getProdutos();
                })
                .orElseThrow(() -> new RuntimeException("Sem produtos cadastrados nessa categoria"));
    }
}
