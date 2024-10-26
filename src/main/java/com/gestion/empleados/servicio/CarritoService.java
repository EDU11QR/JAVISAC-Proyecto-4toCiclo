package com.gestion.empleados.servicio;

import java.util.List;

import javax.servlet.http.HttpSession;


import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Producto;
import com.gestion.empleados.entidades.Venta;

public interface CarritoService {
	public void save(Producto productoo, Integer cantidad, HttpSession session);
	public void saveCliente(Empleado empleado, HttpSession session);
	public Venta traerventa( HttpSession session);
	public void delete(Long id, HttpSession session);
}
