package com.parada.rf.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParadaNotFoundException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public ParadaNotFoundException(Long id) {
        super("Veiculo não existe... Id: " + id);
    }

}
