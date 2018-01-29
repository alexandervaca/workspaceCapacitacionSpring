/*
 * Cuenta.java
 *
 * Created on 17 de noviembre de 2008, 14:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.eduit.spring.clase2.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cuenta implements Serializable {

	private Long id;
	private List<Cliente> clientes;
	private Double saldo;

	public Cuenta() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_cuenta")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "cuentas_cliente", joinColumns = { @JoinColumn(name = "numero_cuenta") }, inverseJoinColumns = { @JoinColumn(name = "id_cliente") })
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Column(name = "saldo")
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta{" + "id=" + id + ", saldo=" + saldo + '}';
	}
}
