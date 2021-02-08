package br.com.homeschool.nmaisum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.homeschool.nmaisum.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// resolução do problema no N+1 com paginação
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories cat WHERE obj IN :products")
	List<Product> findAllProductsCategories(List<Product> products);
}
