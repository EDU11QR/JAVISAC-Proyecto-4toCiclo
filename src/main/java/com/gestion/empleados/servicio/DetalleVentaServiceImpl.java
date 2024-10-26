package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Venta;
import com.gestion.empleados.repositorios.DetalleVentaRepository;
import com.gestion.empleados.repositorios.EmpleadoRepository;
import com.gestion.empleados.repositorios.VentaRepository;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;

	@Override
	public void save(DetalleVenta detalleVenta) {
		detalleVentaRepository.save(detalleVenta);
	}

}
