package com.udemy.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = clienteService.findAll();
		return ResponseEntity.ok().body(lista);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
