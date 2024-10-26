package com.gestion.empleados.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.entidades.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

}
