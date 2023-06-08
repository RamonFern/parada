package com.parada.rf.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.parada.rf.domain.model.Parada;

public class ParadaCheckOut {
	
	public static final int UMA_HORA = 60;
	public static final int VINTE_QUATRO_HORAS = 24 * UMA_HORA;
	public static final double VALOR_UMA_HORA = 5.00;
	public static final double VALOR_ADICIONAL_POR_HORA = 2.00;
	public static final double VALOR_DIARIA = 20.00;

	public static Double getBill(Parada parada) {
		return getBill(parada.getDataEntrada(), parada.getDatasaida());
	}
	
	public static String getTempo(Parada parada) {
		return getTime(parada.getDataEntrada(), parada.getDatasaida());
	}
	
	 private static Double getBill(LocalDateTime dataEntrada, LocalDateTime dataSaida) {
	        long minutes = dataEntrada.until(dataSaida, ChronoUnit.MINUTES);
	        Double bill = 0.0;
	        if (minutes <= UMA_HORA) {
	            return VALOR_UMA_HORA;
	        }
	        if (minutes <= VINTE_QUATRO_HORAS) {
	            bill = VALOR_UMA_HORA;
	            int hours = (int) (minutes / UMA_HORA);
	            for (int i = 0; i < hours; i++) {
	                bill += VALOR_ADICIONAL_POR_HORA;
	            }
	            return bill;
	        }
	        int days = (int) (minutes / VINTE_QUATRO_HORAS);
	        for (int i = 0; i < days; i++) {
	            bill += VALOR_DIARIA;
	        }
	        return bill;
	    }
	 
	 
	private static String getTime(LocalDateTime dataEntrada, LocalDateTime dataSaida) {
	        Long minutes = dataEntrada.until(dataSaida, ChronoUnit.MINUTES);
	        
	        if (minutes <= UMA_HORA) {
	            return " " + minutes + " min";
	        }
	        
	        if (minutes <= VINTE_QUATRO_HORAS) {
	            
	            int hours = (int) (minutes / UMA_HORA);
	            double min = (minutes % UMA_HORA);
	            
	            return " "+ hours +" horas e " + min + " min ";
	        }
	        
	        int days = (int) (minutes / VINTE_QUATRO_HORAS);
	        int hoursRest = (int) (minutes % VINTE_QUATRO_HORAS);
	        int hours = (int) (hoursRest / UMA_HORA );
	        
	        int minRest = (int) (hoursRest % UMA_HORA );
	        int min = (int) (minRest % UMA_HORA);
	             
	        return " "+ days + " dias " + hours + " horas e " + min + " min ";
	        
	    }


}
