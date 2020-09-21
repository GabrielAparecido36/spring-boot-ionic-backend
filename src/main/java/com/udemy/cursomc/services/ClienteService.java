package com.udemy.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.repositories.ClienteRepository;
import com.udemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não enconstrado! Id: "+ id + ", Tipo: "+ Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		List<Cliente> obj = clienteRepository.findAll();
		return obj;
	}

	
}
