package com.parada.rf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parada.rf.domain.dto.ParadaCreateDTO;
import com.parada.rf.domain.dto.ParadaDTO;
import com.parada.rf.domain.mapper.ParadaMapper;
import com.parada.rf.domain.model.Parada;
import com.parada.rf.service.ParadaService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/parada")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200/")
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
	@Operation(summary = "Criar parada")
	public ResponseEntity<ParadaDTO> create(@RequestBody ParadaDTO dto) {
		var paradaCreate = paradaMapper.toParada(dto);
		var parada = paradaService.create(paradaCreate);
		var result = paradaMapper.toParadaDTO(parada);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar parada por id")
	public ResponseEntity<ParadaDTO> findById(@PathVariable Long id) {
		Parada parada = paradaService.findById(id);
		ParadaDTO result = paradaMapper.toParadaDTO(parada);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar parada")
	public ResponseEntity<ParadaDTO> update(@PathVariable Long id, @RequestBody ParadaCreateDTO paradaCreteDTO) {
		Parada paradaUpdate = paradaMapper.toParadaCreate(paradaCreteDTO);
		Parada parada = paradaService.update(id, paradaUpdate);
        return ResponseEntity.ok(paradaMapper.toParadaDTO(parada));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Excluir parada")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		paradaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}")
	@Operation(summary = "Fazer check-out de parada")
    public ResponseEntity<ParadaDTO> checkOut(@PathVariable Long id) {
		Parada parada = paradaService.checkOut(id);
        return ResponseEntity.ok(paradaMapper.toParadaDTO(parada));
    }
	
//	@CrossOrigin(origins = "http://localhost:4200/parada/parcial/{id}")
//	@GetMapping("/parcial/{id}")
//	@Operation(summary = "Parcial de check-out")
//    public ResponseEntity<ParadaDTO> parcialCheckOut(@PathVariable Long id) {
//		Parada parada = paradaService.parcialCheckOut(id);
//        return ResponseEntity.ok(paradaMapper.toParadaDTO(parada));
//    }
	
	
//	@PostMapping("/parcial/{id}")
//	@Operation(summary = "Fazer check-out de parada")
//    public Double parcialCheckOut(@PathVariable Long id) {
//		Double valor = paradaService.parcialCheckOut(id);
//        return valor;
//    }
	
	
	
	
	

}
