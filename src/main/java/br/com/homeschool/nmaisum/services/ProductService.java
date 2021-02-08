package br.com.homeschool.nmaisum.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.homeschool.nmaisum.dto.ProductDTO;
import br.com.homeschool.nmaisum.entities.Product;
import br.com.homeschool.nmaisum.repositories.ProductRepository;

/* @Service/@Component: registra a classe como um componente monitorado pelo spring boot
 * possibilitando a injeção de dependencia desta classe no controlador ou em outras classes*/

@Service 
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	//	//injeção de dependencia desacoplada sem @autowired
	//	public ProductService(ProductRepository repository) {
	//		this.repository = repository;
	//	}
	
	//	@Transactional(readOnly = true) //fecha a conexão e evita o locking de escrita no banco de dados
	//	public List<ProductDTO> findAll() {
	//		List<Product> list = repository.findAll();
	//		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	//	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(PageRequest pageRequest) {
		Page<Product> page = repository.findAll(pageRequest);
		//transforma a pagina em lista
		repository.findAllProductsCategories(page.stream().collect(Collectors.toList()));
		return page.map(x -> new ProductDTO(x));
	}
	
}
