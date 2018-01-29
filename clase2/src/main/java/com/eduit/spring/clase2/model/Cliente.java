/*
 * Cliente.java
 *
 */

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
@Table(name = "cliente")
public class Cliente implements Serializable {

	private Long id;
	private String nombres;
	private String direccion;
	private List<Cuenta> cuentas;
	private List<Seguro> seguros;
	private List<Tarjeta> tarjetas;

	public Cliente() {
		cuentas = new ArrayList<Cuenta>();
		seguros = new ArrayList<Seguro>();
		tarjetas = new ArrayList<Tarjeta>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombres;
	}

	public void setNombre(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "cuentas_cliente", joinColumns = { @JoinColumn(name = "id_cliente") }, inverseJoinColumns = { @JoinColumn(name = "numero_cuenta") })
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "f_cliente")
	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tarjetas_cliente", joinColumns = { @JoinColumn(name = "id_cliente") }, inverseJoinColumns = { @JoinColumn(name = "numero_tarjeta") })
	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public String toString() {
		return "Cliente{" + "direccion='" + direccion + '\'' + ", nombres='" + nombres + '\'' + ", id=" + id + '}';
	}
}
