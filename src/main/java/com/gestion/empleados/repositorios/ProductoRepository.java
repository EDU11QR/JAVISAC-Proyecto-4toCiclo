package com.gestion.empleados.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gestion.empleados.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
