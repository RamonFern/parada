package com.parada.rf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parada.rf.domain.mapper.ParadaMapper;
import com.parada.rf.service.ParadaService;

@RestController
@RequestMapping("/check")
@CrossOrigin(origins = "http://localhost:4200/")
public class CheckController {
	
	private final ParadaService paradaService;
	private final ParadaMapper paradaMapper;
	
	@Autowired
	public CheckController(ParadaService paradaService,
			ParadaMapper paradaMapper) {
		this.paradaService = paradaService;
		this.paradaMapper = paradaMapper;
	}
	
//	@GetMapping("/{id}")
//	@Operation(summary = "Parcial de check-out")
//    public ResponseEntity<ParadaDTO> parcialCheckOut(@PathVariable Long id) {
//		Parada parada = paradaService.parcialCheckOut(id);
//        return ResponseEntity.ok(paradaMapper.toParadaDTO(parada));
//    }

}
