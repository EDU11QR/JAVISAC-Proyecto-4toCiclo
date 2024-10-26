package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.entidades.Producto;
import com.gestion.empleados.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productorepository;

	// Metodo pa listar producto
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {

		// casteamos el retorno
		return (List<Producto>) productorepository.findAll();

	}// fin del metodo listar producto

	// Metodo
	@Override
	@Transactional(readOnly = true)
	public Page<Producto> finAll(Pageable pageable) {
		// retornamos lo mismo de listar
		return productorepository.findAll(pageable);
	}

	// Metodo para guardar Producto
	@Override
	@Transactional
	public void save(Producto producto) {
		// mandamos a guardar
		productorepository.save(producto);

	}

	// Metodo solo de lectura
	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long idp) {
		// retornamos el repositorio
		return productorepository.findById(idp).orElse(null);

	}

	// Metodo para eliminar Producto
	@Override
	@Transactional
	public void delete(Long idp) {
		//
		productorepository.deleteById(idp);

	}

}
