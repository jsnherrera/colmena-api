package com.api.colmena.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.colmena.model.Venta;

@Repository
public interface IVentaRepo extends JpaRepository<Venta, Long> {

	@Query("select venta from Venta venta where venta.fechaaudit between ?1 and ?2 and estatus = 1")
	public List<Venta> findAll(Date fechaini, Date fechafin);

}
