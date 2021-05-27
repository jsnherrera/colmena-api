package com.api.colmena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.colmena.model.DetalleVenta;

@Repository
public interface IDetalleVentaRepo extends JpaRepository<DetalleVenta, Long> {

}
