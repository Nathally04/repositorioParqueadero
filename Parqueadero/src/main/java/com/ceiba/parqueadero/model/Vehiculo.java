package com.ceiba.parqueadero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")

public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;

	//Attributes
	@Id
	@Column (name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column (name="placa")
	public String placa;
	
	@Column (name="cilindraje", nullable= true)
	public int cilindraje;
	
	@Column (name="estado")
	public boolean estado;
	
	@Column (name="tipo_de_vehiculo", nullable= true)
	public int tipo;
	
	
	
	public Vehiculo(String placa, boolean estado) {
		super();
		this.placa = placa;
		this.estado = estado;
	}

	//Constructor
	public Vehiculo(String placa) {
		this.placa = placa;
	}
	
	public Vehiculo() {
		super();
	}

	public Vehiculo(String placa, int cilindraje, boolean estado, int tipo) {
		super();
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.estado = estado;
		this.tipo = tipo;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
