package com.api.colmena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.colmena.model.Venta;

@Repository
public interface IVentaRepo extends JpaRepository<Venta, Long> {

}
