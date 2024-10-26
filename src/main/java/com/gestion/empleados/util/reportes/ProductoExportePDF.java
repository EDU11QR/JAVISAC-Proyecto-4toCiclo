package com.gestion.empleados.util.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.gestion.empleados.entidades.Producto;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ProductoExportePDF {

	private List<Producto> listaProducto;

	

	
	public ProductoExportePDF(List<Producto> listaProducto) {
		super();
		this.listaProducto = listaProducto;
	}

	private void escribirCabeceraDeLaTablaP(PdfPTable tablap) {
		// lamamos metodos para armar celdas de pdf
		PdfPCell celda = new PdfPCell();
		// styles de celdas
		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		// Agregamos una fuente o tipo de letra
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		// Declarando nombres de las tablas
		celda.setPhrase(new Phrase("ID", fuente));
		tablap.addCell(celda);
		celda.setPhrase(new Phrase("Descripcion", fuente));
		tablap.addCell(celda);
		celda.setPhrase(new Phrase("Precio", fuente));
		tablap.addCell(celda);
		celda.setPhrase(new Phrase("Stock", fuente));
		tablap.addCell(celda);

	}

	private void escribirDatosDeLaTablap(PdfPTable tablap) {
		// agregamos bucle
		for (Producto producto : listaProducto) {
			// Agredando los datos a la tabla, llamano los metodos
			tablap.addCell(String.valueOf(producto.getIdp()));
			tablap.addCell(String.valueOf(producto.getNombrep()));
			tablap.addCell(String.valueOf(producto.getPreciop()));
			tablap.addCell(String.valueOf(producto.getStock()));
		}

	}// fin del metodo escribir

	public void exportarp(HttpServletResponse response) throws DocumentException, IOException {
		// mandando a imprimir en una hoja A4
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de Productos", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(4);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 2.3f, 1.2f });

		escribirCabeceraDeLaTablaP(tabla);
		escribirDatosDeLaTablap(tabla);

		documento.add(tabla);
		documento.close();

	}
}
