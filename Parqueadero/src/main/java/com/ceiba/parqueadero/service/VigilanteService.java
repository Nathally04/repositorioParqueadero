package com.ceiba.parqueadero.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.ParqueaderoDao;

@Service
@Transactional
public class VigilanteService {

		@Autowired
		public ParqueaderoDao registrosParqueaderoDao;
		
		public boolean tipoVehiculo (int tipo) {
			return tipo == TipoVehiculo.CARRO.getTipoVehiculo();
		}
		
		public boolean comprobarLetraInicial (String placa) {	
			return placa.substring(0, 1).equalsIgnoreCase("a");
		}
		
		public boolean obtenerDia (Date dia){
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(dia);
			return calendario.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY || calendario.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY;
		}
		
		public boolean consultarCantidadCeldas(int tipoVehiculo) {
			boolean hayEspacio = false;
			if( tipoVehiculo == TipoVehiculo.CARRO.getTipoVehiculo() ) {
				hayEspacio = registrosParqueaderoDao.consultarCantidadCeldas( tipoVehiculo ) < ParametrosParqueadero.CELDAS_CARROS;
			}else {
				hayEspacio = registrosParqueaderoDao.consultarCantidadCeldas( tipoVehiculo ) < ParametrosParqueadero.CELDAS_MOTOS;		
			}
			return hayEspacio;
			
		}

		public boolean verificarEstado(boolean estado)	{
			return estado;
		}
		
		public boolean validoIngresarVehiculo( String placa, Date dia ) {
			return !comprobarLetraInicial( placa ) || (comprobarLetraInicial( placa ) && obtenerDia( dia ));
		}

		public boolean verificarCilindraje(int cilindraje) {
				return cilindraje > ParametrosParqueadero.CILINDRAJE_MINIMO;
		}
	
}
