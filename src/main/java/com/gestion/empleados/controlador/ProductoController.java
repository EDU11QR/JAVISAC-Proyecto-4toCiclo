package com.gestion.empleados.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion.empleados.entidades.Producto;
import com.gestion.empleados.servicio.ProductoService;
import com.gestion.empleados.util.paginacion.PageRender;
import com.gestion.empleados.util.reportes.ProductoExportePDF;
import com.gestion.empleados.util.reportes.ProductoExporterExcel;
import com.lowagie.text.DocumentException;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoservice;

	@GetMapping("/verp/{idp}")
	public String verDetallesDelProducto(@PathVariable(value = "idp") Long idp, Map<String, Object> modelo,
			RedirectAttributes flash) {
		Producto producto = productoservice.findOne(idp);
		// aplicamos metodo if
		if (producto == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos");
			return "redirect:/listarp";
		}

		modelo.put("producto", producto);
		modelo.put("titulo", "Detalles del Producto" + producto.getNombrep());
		return "verp";
	}// fin del Metodo ver Detalle

	@GetMapping({ "/l", "/listarp", "" })
	public String ListarProducto(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 10);
		// indicamos las paginas que va mostrar
		Page<Producto> producto = productoservice.finAll(pageRequest);
		//
		PageRender<Producto> pageRender = new PageRender<>("/listarp", producto);

		modelo.addAttribute("titulo", "Listado de Producto");
		modelo.addAttribute("producto", producto);
		modelo.addAttribute("page", pageRender);
		return "listarp";

	}// fin del metodo Listar

	@GetMapping("/formp")
	public String mostarFormularioDeRegistrarProducto(Map<String, Object> modelo) {
		Producto producto = new Producto();
		modelo.put("producto", producto);
		modelo.put("titulo", "Registro de Producto");
		return "formp";
	}// fin de metodo mostrar formulario

	@PostMapping("/formp")
	public String guardarProducto(@Valid Producto producto, BindingResult result, Model modelo,
			RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			modelo.addAttribute("titulo", "Registro de Prodcuto");
			return "formp";
		}

		String mensaje = (producto.getIdp() != null) ? "El Producto a sido editado con Exito"
				: "Producto registrado con exito";

		productoservice.save(producto);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:/listarp";

	}// fin del metodo guardar

	@GetMapping("/formp/{idp}")
	public String editarProducto(@PathVariable(value = "idp") Long idp, Map<String, Object> modelo,
			RedirectAttributes flash) {
		Producto producto = null;
		if (idp > 0) {
			producto = productoservice.findOne(idp);
			if (producto == null) {
				flash.addFlashAttribute("error", "El ID del Producto no exste en la base de datos");
				return "redirect:/listarp";
			}
		} else {
			flash.addAttribute("error", "El ID del Producto no puede ser 0");
			return "redirect:/listarp";

		}
		modelo.put("producto", producto);
		modelo.put("titulo", "Edicion de Producto");
		return "formp";
	}// fin del metodo editar

	@GetMapping("/eliminarp/{idp}")
	public String eliminarProducto(@PathVariable(value = "idp") Long idp, RedirectAttributes flash) {
		if (idp > 0) {
			productoservice.delete(idp);
			flash.addFlashAttribute("success", "Producto Eliminado con exito");

		}
		return "redirect:/listarp";
	}// fin del metodo eliminar
	
	
	
	//Metodo para Exportar reporte en PDF
	@GetMapping("/exportarPDFp")
	public void exportarListadoDeProductoEnPdf(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		 //declaramos para mostrar la fecha actual
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Producto_"+ fechaActual +".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Producto> producto = productoservice.findAll();
		
		ProductoExportePDF exporter = new ProductoExportePDF(producto);
		exporter.exportarp(response);
	
			
	}// Fin del metodo Exportar PDF
	
	
	//Metodo para Exportar reporte en Excel
		@GetMapping("/exportarExcelp")
		public void exportarListadoDeProductoEnExcelp(HttpServletResponse response) throws DocumentException, IOException {
			
			response.setContentType("application/octec-stream");
			 //declaramos para mostrar la fecha actual
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String fechaActual = dateFormatter.format(new Date());
			
			String cabecera = "Content-Disposition";
			String valor = "attachment; filename=Producto_"+ fechaActual +".xlsx";
			
			response.setHeader(cabecera, valor);
			
			List<Producto> producto = productoservice.findAll();
			
			ProductoExporterExcel exporter = new ProductoExporterExcel(producto);
			exporter.exportar(response);
		
				
		}// Fin del metodo Exportar Excel
		
	
	

}// fin del controlador
