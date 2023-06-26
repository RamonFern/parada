package com.parada.rf.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parada.rf.domain.exception.ParadaNotFoundException;
import com.parada.rf.domain.model.Parada;
import com.parada.rf.repository.ParadaRepository;


@Service
public class ParadaService {
	
	private final ParadaRepository paradaRepository;
	
	@Autowired
	public ParadaService(ParadaRepository paradaRepository) {
		this.paradaRepository = paradaRepository;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Parada> findAll() {
		return paradaRepository.findAll();
	}

	@Transactional
	public Parada create(Parada paradaCreate) {
		paradaCreate.setDataEntrada(LocalDateTime.now());
		paradaRepository.save(paradaCreate);
		return paradaCreate;
	}

	@Transactional(readOnly = true)
	public Parada findById(Long id) {
		return paradaRepository.findById(id).orElseThrow(() -> new ParadaNotFoundException(id));
	}

	@Transactional
	public Parada update(Long id, Parada paradaUpdate) {
		Parada parada = findById(id);
		parada.setCor(paradaUpdate.getCor());
		parada.setEstado(paradaUpdate.getEstado());
		parada.setModelo(paradaUpdate.getModelo());
		parada.setPlaca(paradaUpdate.getPlaca());
		paradaRepository.save(parada);
		return parada;
	}

	@Transactional
	public void delete(Long id) {
		findById(id);
		paradaRepository.deleteById(id);
	}

	public Parada checkOut(Long id) {
		Parada parada = findById(id);
		parada.setDatasaida(LocalDateTime.now());
		parada.setValor(ParadaCheckOut.getBill(parada));
		parada.setTempo(ParadaCheckOut.getTempo(parada));
		paradaRepository.save(parada);
		return parada;
	}
	
//	public Parada parcialCheckOut(Long id) {
//		Parada parada = findById(id);
//		parada.setDatasaida(LocalDateTime.now());
//		parada.setValor(ParadaCheckOut.getBill(parada));
//		parada.setTempo(ParadaCheckOut.getTempo(parada));
//		
//		return parada;
//	}

	

}
