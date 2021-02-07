package br.com.homeschool.nmaisum.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.homeschool.nmaisum.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO() {
	}

	public ProductDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		categories = entity.getCategories().stream()
					.map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		Collections.sort(categories, Comparator.comparing(CategoryDTO::getName));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

}
