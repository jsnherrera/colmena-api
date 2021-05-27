package com.api.colmena.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

	@Column(nullable = false)
	private double totalventa;
	@Column(nullable = false)
	private double efectivoventa;
	@Column(nullable = false)
	private double cambioventa;
	@Column(nullable = false)
	private Date fechaaudit;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
	private List<DetalleVenta> detalles;

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalventa() {
		return totalventa;
	}

	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}

	public double getEfectivoventa() {
		return efectivoventa;
	}

	public void setEfectivoventa(double efectivoventa) {
		this.efectivoventa = efectivoventa;
	}

	public double getCambioventa() {
		return cambioventa;
	}

	public void setCambioventa(double cambioventa) {
		this.cambioventa = cambioventa;
	}

	public Date getFechaaudit() {
		return fechaaudit;
	}

	public void setFechaaudit(Date fechaaudit) {
		this.fechaaudit = fechaaudit;
	}

}
