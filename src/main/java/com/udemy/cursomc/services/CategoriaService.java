package com.udemy.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não enconstrado! Id: "+ id + ", Tipo: "+ Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		List<Categoria> obj = categoriaRepository.findAll();
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
		
	}
	
	public Categoria update(Categoria obj) {
		findById(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);			
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluír uma categoria que possuí produtos");
		}
		
	}
	
}
