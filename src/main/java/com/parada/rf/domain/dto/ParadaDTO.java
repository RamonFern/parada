package com.parada.rf.domain.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParadaDTO {
	
	private Long id;
    private String placa;
    private String estado;
    private String modelo;
    private String cor;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataEntrada;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime datasaida;
    private Double valor;
}
