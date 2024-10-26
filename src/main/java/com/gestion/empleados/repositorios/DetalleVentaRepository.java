package com.gestion.empleados.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gestion.empleados.entidades.DetalleVenta;
import com.gestion.empleados.entidades.Empleado;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long>{

}
