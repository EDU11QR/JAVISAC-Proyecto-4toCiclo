package com.gestion.empleados.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gestion.empleados.entidades.Producto;

public class ProductoExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Producto> listaProducto;

	public ProductoExporterExcel(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Producto");

	}

	private void escribirCabeceraDeLaTablap() {
		Row fila = hoja.createRow(0);

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		// DECLARANDO LAS CELDAS DONDE SE UBICAN LOS DATOS
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);

		celda = fila.createCell(1);
		celda.setCellValue("Nombre");
		celda.setCellStyle(estilo);

		celda = fila.createCell(2);
		celda.setCellValue("Precio");
		celda.setCellStyle(estilo);

		celda = fila.createCell(3);
		celda.setCellValue("Stock");
		celda.setCellStyle(estilo);

	}

	private void escribirDatosDeLaTablap() {
		int nueroFilas = 1;

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);

		// agregamos un bucle

		for (Producto producto : listaProducto) {

			Row fila = hoja.createRow(nueroFilas++);

			Cell celda = fila.createCell(0);
			celda.setCellValue(producto.getIdp());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);

			celda = fila.createCell(1);
			celda.setCellValue(producto.getNombrep());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);

			celda = fila.createCell(2);
			celda.setCellValue(producto.getPreciop());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

			celda = fila.createCell(3);
			celda.setCellValue(producto.getStock());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

		}

	}

	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeLaTablap();
		escribirDatosDeLaTablap();

		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		// cerramos
		libro.close();
		outPutStream.close();
	}

}
