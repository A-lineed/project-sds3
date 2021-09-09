package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSucessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service // Registrar a classe como um  componente do sistema que pode ser injetado em outros componentes 
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerrepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerrepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		//Map -> Converte minha coleção para uma nova coleção.
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupeBySeller() {
		return repository.amountGroupeBySeller();
		
	}; 
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupeBySeller() {
		return repository.sucessGroupeBySeller();
		
	}; 
}
