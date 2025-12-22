package dev.bruno.product_category.service;

import dev.bruno.product_category.entity.Produto;
import dev.bruno.product_category.repository.CategoriaRepository;
import dev.bruno.product_category.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;


    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;

    }

    public void criarProduto(Produto produto, Long idCategoria) {

        categoriaRepository.findById(idCategoria)
                .map(categoria -> { produto.setCategoria(categoria);
                    Produto novoProduto = produtoRepository.save(produto);
                    return novoProduto;
                })
                .orElseThrow(() -> new RuntimeException("Falha na criação de um produto, categoria não existe"));
    }

    public List<Produto> listarProdutos()  {
        return produtoRepository.findAll();
    }
}
