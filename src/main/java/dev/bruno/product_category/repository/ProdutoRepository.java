package dev.bruno.product_category.repository;

import dev.bruno.product_category.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
