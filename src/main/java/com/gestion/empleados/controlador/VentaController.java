package com.gestion.empleados.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Producto;
import com.gestion.empleados.entidades.Venta;
import com.gestion.empleados.servicio.CarritoService;
import com.gestion.empleados.servicio.EmpleadoService;
import com.gestion.empleados.servicio.ProductoService;
import com.gestion.empleados.servicio.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	private ProductoService productoservice;

	@Autowired
	private VentaService ventaService;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private CarritoService carritoService;

	@GetMapping("")
	public String Index(Model model, HttpSession session) {
		if (session.getAttribute("venta") == null) {
			session.setAttribute("venta", new Venta());
		}
		Venta venta = carritoService.traerventa(session);
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		model.addAttribute("venta", venta);
		model.addAttribute("montoTotal", carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum());
		return "venta/index";
	}

	@GetMapping("/agregar")
	public String agregarcarrito(@RequestParam Integer cantidad, @RequestParam Long idProducto, Model model,
			HttpSession session) {
		Producto prodicut = productoservice.findOne(idProducto);
		carritoService.save(prodicut, cantidad, session);
		Venta venta = carritoService.traerventa(session);
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		model.addAttribute("venta", venta);
		model.addAttribute("montoTotal", carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum());
		return "venta/index";
	}

	@GetMapping("/eliminar")
	public String elimanrprodcutodelcarrito(@RequestParam Long idProducto, Model model, HttpSession session) {
		carritoService.delete(idProducto, session);
		Venta venta = carritoService.traerventa(session);
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		model.addAttribute("venta", venta);
		model.addAttribute("montoTotal", carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum());
		return "venta/index";
	}

	@GetMapping("/buscarProducto")
	public String buscarProducto(@RequestParam Long idProducto, Model model, HttpSession session) {
		Producto prodicut = productoservice.findOne(idProducto);
		Venta venta = carritoService.traerventa(session);
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		model.addAttribute("venta", venta);
		model.addAttribute("prodicut", prodicut);
		model.addAttribute("montoTotal", carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum());
		return "venta/index";
	}

	@GetMapping("/buscarcliente")
	public String buscarcliente(@RequestParam Long idCcliuente, Model model, HttpSession session) {
		Empleado empleado = empleadoService.findOne(idCcliuente);
		carritoService.saveCliente(empleado, session);
		Venta venta = carritoService.traerventa(session);
		List<DetalleVenta> carrito = venta.getDetalleVentaList();
		model.addAttribute("venta", venta);
		model.addAttribute("montoTotal", carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum());
		return "venta/index";
	}

	@GetMapping("/generarventa")
	public String buscarcliente(Model model, HttpSession session) {
		int monto = 0;
		Venta venta = carritoService.traerventa(session);
		ventaService.save(venta, venta.getDetalleVentaList().stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum(),
				session);
		venta = carritoService.traerventa(session);
		model.addAttribute("venta", venta);
		model.addAttribute("montoTotal", monto);
		return "venta/index";
	}
}
