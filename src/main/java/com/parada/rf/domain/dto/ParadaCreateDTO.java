package com.parada.rf.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParadaCreateDTO {

	private String placa;
	private String estado;
	private String modelo;
	private String cor;
}
