package com.parada.rf.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	/*
	 * @Transactional
	public Estacionamento create(Estacionamento estacionamentoCreate) {
		String uuid = getUUID();
		estacionamentoCreate.setId(uuid);
		estacionamentoCreate.setDataEntrada(LocalDateTime.now());
		estacionamentoRepository.save(estacionamentoCreate);
		return estacionamentoCreate;
	}*/

}
