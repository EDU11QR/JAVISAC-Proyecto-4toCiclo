package com.gestion.empleados.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codVen;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fchVen;

	private Double monto;

	@ManyToOne
	private Empleado empleado;

	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleVenta> detalleVentaList = new ArrayList<>();

	public Long getCodVen() {
		return codVen;
	}

	public void setCodVen(Long codVen) {
		this.codVen = codVen;
	}

	public Date getFchVen() {
		return fchVen;
	}

	public void setFchVen(Date fchVen) {
		this.fchVen = fchVen;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<DetalleVenta> getDetalleVentaList() {
		return detalleVentaList;
	}

	public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
		this.detalleVentaList = detalleVentaList;
	}

	public Venta(Long codVen, Date fchVen, Double monto, Empleado empleado, List<DetalleVenta> detalleVentaList) {
		super();
		this.codVen = codVen;
		this.fchVen = fchVen;
		this.monto = monto;
		this.empleado = empleado;
		this.detalleVentaList = detalleVentaList;
	}

	public Venta() {
		super();
	}
	
	
}
