package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SellerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;

	public SellerDTO() {

	}

	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public SellerDTO(Seller entity) {                                                      // Para que eu possa copiar facilmente os dados de uma entidade para o DTO
		id = entity.getId();                                                              // Pegar o entity da entidade e copiar para o id do DTO.
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
