package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestion.empleados.entidades.Producto;

public interface ProductoService {

	public List<Producto> findAll();

	public Page<Producto> finAll(Pageable pageable);

	public void save(Producto producto);

	public Producto findOne(Long idp);

	public void delete(Long idp);

}
