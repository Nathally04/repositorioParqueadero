package com.ceiba.parqueadero.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.Vehiculo;

@Repository("vehiculoDao")
@Transactional
public class VehiculoDaoImpl extends SessionObjeto implements VehiculoDao{

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		getSession().persist(vehiculo);
	}

	@Override
	public Vehiculo consultarVehiculoPorPlaca(String placa) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where placa = :placa")
				.setParameter("placa", placa).uniqueResult();
	}
	
	@Override
	public Vehiculo consultarVehiculoPorEstado(boolean estado) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where estado = :estado")
				.setParameter("estado", estado);
	}

	@Override
	public void salirVehiculo(Vehiculo vehiculo) {
		getSession().update(vehiculo);
	}

	@Override
	public int consultarCantidadCarros() {
		int cantidad= ((Number) getSession()
				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=1")
				.uniqueResult()).intValue();
		return cantidad;
	}
	
	@Override
	public int consultarCantidadCeldas( int tipoVehiculo ) {
		
		return ((Number) getSession().createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=:tipo")
					.setParameter("tipo", tipoVehiculo).uniqueResult()).intValue();
//		return Integer.parseInt( String.valueOf( query.uniqueResult() ) );
		
		
//		int cantidad= ((Number) getSession()
//				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=:1")
//				.uniqueResult()).intValue();
//		return cantidad;
	}

	@Override
	public int consultarCantidadMotos() {
		int cantidad= ((Number) getSession()
				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=2")
				.uniqueResult()).intValue();
		return cantidad;
	}
}