package br.com.homeschool.nmaisum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeschool.nmaisum.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
