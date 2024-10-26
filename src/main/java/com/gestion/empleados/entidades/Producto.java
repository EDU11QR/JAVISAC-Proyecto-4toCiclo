package com.gestion.empleados.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idp;
	@NotEmpty
	private String nombrep;

	@NotNull
	private double preciop;
	@NotNull
	private int stock;

	public Producto() {
		super();
	}

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
	}

	public String getNombrep() {
		return nombrep;
	}

	public void setNombrep(String nombrep) {
		this.nombrep = nombrep;
	}

	public double getPreciop() {
		return preciop;
	}

	public void setPreciop(double preciop) {
		this.preciop = preciop;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
