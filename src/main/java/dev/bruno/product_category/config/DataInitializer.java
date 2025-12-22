package dev.bruno.product_category.config;

import dev.bruno.product_category.entity.Categoria;
import dev.bruno.product_category.entity.Produto;
import dev.bruno.product_category.repository.CategoriaRepository;
import dev.bruno.product_category.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public DataInitializer(ProdutoRepository produtoRepository,  CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria categoria = new Categoria("Informática");
        Categoria categoria2 = new Categoria("Quarto");

        categoriaRepository.save(categoria);
        categoriaRepository.save(categoria2);

        Produto produto = new Produto("Mouse", 200.0, categoria);
        Produto produto2 = new Produto("Teclado", 200.0, categoria);
        Produto produto3 = new Produto("Ventilador", 450.0, categoria2);

        produtoRepository.save(produto);
        produtoRepository.save(produto2);
        produtoRepository.save(produto3);
    }
}
