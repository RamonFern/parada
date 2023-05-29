package com.parada.rf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parada.rf.domain.dto.ParadaDTO;
import com.parada.rf.domain.mapper.ParadaMapper;
import com.parada.rf.domain.model.Parada;
import com.parada.rf.service.ParadaService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/parada")
@CrossOrigin(origins = "*")
public class ParadaController {
	
	private final ParadaService paradaService;
	private final ParadaMapper paradaMapper;
	
	@Autowired
	public ParadaController(ParadaService paradaService,
			ParadaMapper paradaMapper) {
		this.paradaService = paradaService;
		this.paradaMapper = paradaMapper;
	}
	
	@GetMapping
	@Operation(summary = "Listar todas Paradas")
	public ResponseEntity<List<ParadaDTO>> findAll() {

		List<Parada> paradaList = paradaService.findAll();
		List<ParadaDTO> result = paradaMapper.toParadaDTOList(paradaList);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<ParadaDTO> create(@RequestBody ParadaDTO dto) {
		var paradaCreate = paradaMapper.toParada(dto);
		var parada = paradaService.create(paradaCreate);
		var result = paradaMapper.toParadaDTO(parada);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	/*
	 * @PostMapping
	public ResponseEntity<EstacionamentoDTO> create(@RequestBody EstacionamentoCreateDTO dto) {
		var estacionamentoCreate = estacionamentoMapper.toEstacionamentoCreate(dto);
		var estacionamento = estacionamentoService.create(estacionamentoCreate);
		var result = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}*/
	
	
	

}
