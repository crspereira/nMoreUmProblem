package br.com.homeschool.nmaisum.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.homeschool.nmaisum.dto.CategoryDTO;
import br.com.homeschool.nmaisum.entities.Category;
import br.com.homeschool.nmaisum.repositories.CategoryRepository;

/* @Service/@Component: registra a classe como um componente monitorado pelo spring boot
 * possibilitando a injeção de dependencia desta classe no controlador ou em outras classes*/

@Service 
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	//	//injeção de dependencia desacoplada sem @autowired
	//	public CategoryService(CategoryRepository repository) {
	//		this.repository = repository;
	//	}
	
	@Transactional(readOnly = true) //fecha a conexão e evita o locking de escrita no banco de dados
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
}
