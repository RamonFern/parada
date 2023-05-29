package com.parada.rf.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.parada.rf.domain.dto.ParadaCreateDTO;
import com.parada.rf.domain.dto.ParadaDTO;
import com.parada.rf.domain.model.Parada;

@Component
public class ParadaMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ParadaDTO toParadaDTO(Parada parada) {
        return MODEL_MAPPER.map(parada, ParadaDTO.class);
    }
	
	public List<ParadaDTO> toParadaDTOList(List<Parada> paradaList) {
	    return paradaList.stream().map(this::toParadaDTO).collect(Collectors.toList());
	}
	
	 public Parada toParada(ParadaDTO dto) {
	     return MODEL_MAPPER.map(dto, Parada.class);
	}
	    
	public Parada toParadaCreate(ParadaCreateDTO dto) {
	     return MODEL_MAPPER.map(dto, Parada.class);
	}
	

}
