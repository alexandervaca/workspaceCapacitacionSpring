package com.eduit.spring.clase2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarjeta")
public class Tarjeta implements Serializable {

	private Long id;
	private Double saldo;
	private List<Cliente> clientes;
	private List<Resumen> resumenes;

	public Tarjeta() {
		resumenes = new ArrayList<Resumen>();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_tarjeta")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "saldo")
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tarjetas_cliente", joinColumns = { @JoinColumn(name = "numero_tarjeta") }, inverseJoinColumns = { @JoinColumn(name = "id_cliente") })
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "numero_tarjeta")
	public List<Resumen> getResumenes() {
		return resumenes;
	}

	public void setResumenes(List<Resumen> resumenes) {
		this.resumenes = resumenes;
	}

}
