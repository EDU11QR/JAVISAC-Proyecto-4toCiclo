package com.gestion.empleados.servicio;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Producto;
import com.gestion.empleados.entidades.Venta;
import com.gestion.empleados.repositorios.EmpleadoRepository;
import com.gestion.empleados.repositorios.VentaRepository;

@Service
public class CarritoServiceImpl implements CarritoService {

	@Override
	public void save(Producto producto, Integer cantidad, HttpSession session) {
		Venta venta = (Venta) session.getAttribute("venta");
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		boolean esta = false;
		for (int i = 0; i < carrito.size(); i++) {
			if (carrito.get(i).getProducto().getIdp() == producto.getIdp()) {
				carrito.get(i).setCantDetVenta(carrito.get(i).getCantDetVenta() + cantidad);
				carrito.get(i).setMontoDetVenta(carrito.get(i).getCantDetVenta() * carrito.get(i).getPreDetVenta());
				esta = true;
			}
		}

		if (!esta) {
			carrito.add(
					new DetalleVenta(cantidad, producto.getPreciop(), (cantidad * producto.getPreciop()), producto));
		}
		venta.setDetalleVentaList(carrito);
		session.setAttribute("venta", venta);
	}

	@Override
	public Venta traerventa(HttpSession session) {
		Venta venta = (Venta) session.getAttribute("venta");
		return venta;
	}

	@Override
	public void delete(Long id, HttpSession session) {
		Venta venta = (Venta) session.getAttribute("venta");
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		for (int i = 0; i < carrito.size(); i++) {
			if (carrito.get(i).getProducto().getIdp() == id) {
				carrito.remove(carrito.get(i));
			}
		}
	}

	@Override
	public void saveCliente(Empleado empleado, HttpSession session) {
		Venta venta = (Venta) session.getAttribute("venta");
		venta.setEmpleado(empleado);
		session.setAttribute("venta", venta);
	}

}
