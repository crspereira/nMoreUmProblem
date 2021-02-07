package br.com.homeschool.nmaisum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeschool.nmaisum.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findAllByOrderByNameAsc();
}

