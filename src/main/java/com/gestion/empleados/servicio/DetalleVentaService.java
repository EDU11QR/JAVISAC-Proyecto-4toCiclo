package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Venta;

public interface DetalleVentaService {
	public void save(DetalleVenta detalleVenta);
}
