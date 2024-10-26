package com.gestion.empleados.servicio;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Venta;
import com.gestion.empleados.repositorios.EmpleadoRepository;
import com.gestion.empleados.repositorios.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository repository;

	@Override
	public void save(Venta venta, Double monto, HttpSession session) {
		for (DetalleVenta deta : venta.getDetalleVentaList()) {
			deta.setVenta(venta);
		}
		venta.setMonto(monto);
		venta.setFchVen(new Date());
		repository.save(venta);
		session.setAttribute("venta", new Venta());
	}

}
