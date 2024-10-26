package com.gestion.empleados.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codDetVenta;
	private Integer cantDetVenta;
	private Double preDetVenta;
	private Double montoDetVenta;

	@ManyToOne
	private Producto producto;

	@ManyToOne
	@JsonBackReference
	private Venta venta;

	public Long getCodDetVenta() {
		return codDetVenta;
	}

	public void setCodDetVenta(Long codDetVenta) {
		this.codDetVenta = codDetVenta;
	}

	public Integer getCantDetVenta() {
		return cantDetVenta;
	}

	public void setCantDetVenta(Integer cantDetVenta) {
		this.cantDetVenta = cantDetVenta;
	}

	public Double getPreDetVenta() {
		return preDetVenta;
	}

	public void setPreDetVenta(Double preDetVenta) {
		this.preDetVenta = preDetVenta;
	}

	public Double getMontoDetVenta() {
		return montoDetVenta;
	}

	public void setMontoDetVenta(Double montoDetVenta) {
		this.montoDetVenta = montoDetVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public DetalleVenta(Long codDetVenta, Integer cantDetVenta, Double preDetVenta, Double montoDetVenta,
			Producto producto, Venta venta) {
		super();
		this.codDetVenta = codDetVenta;
		this.cantDetVenta = cantDetVenta;
		this.preDetVenta = preDetVenta;
		this.montoDetVenta = montoDetVenta;
		this.producto = producto;
		this.venta = venta;
	}

	public DetalleVenta() {
		super();
	}

	public DetalleVenta(Integer cantDetVenta, Double preDetVenta, Double montoDetVenta, Producto producto) {
		super();
		this.cantDetVenta = cantDetVenta;
		this.preDetVenta = preDetVenta;
		this.montoDetVenta = montoDetVenta;
		this.producto = producto;
	}
	
	
}
