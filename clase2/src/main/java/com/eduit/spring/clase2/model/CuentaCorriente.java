/*
 * CuentaCorriente.java
 *
 * Created on 17 de noviembre de 2008, 14:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.eduit.spring.clase2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Table;

@Entity
@Table(name = "cuenta_corriente")
@PrimaryKeyJoinColumn(name = "numero_cuenta")
public class CuentaCorriente extends Cuenta {

	private Double descubierto;

	public CuentaCorriente() {
	}

	@Column(name = "descubierto")
	public Double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}

	@Override
	public String toString() {
		return "Tipo Cuenta : Cuenta Corriente " + " saldo : " + getSaldo() + " descubierto :" + getDescubierto();
	}

}
