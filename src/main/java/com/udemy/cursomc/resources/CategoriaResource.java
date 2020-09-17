package com.udemy.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> lista = categoriaService.findAll();
		return ResponseEntity.ok().body(lista);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = categoriaService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
