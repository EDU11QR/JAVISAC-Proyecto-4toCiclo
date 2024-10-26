package com.gestion.empleados.servicio;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Venta;

public interface VentaService {
	public void save(Venta venta, Double monto, HttpSession session);
}
