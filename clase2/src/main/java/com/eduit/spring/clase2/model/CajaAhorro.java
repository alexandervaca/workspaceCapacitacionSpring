/*
 * CajaAhorro.java
 *
 * Created on 17 de noviembre de 2008, 14:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.eduit.spring.clase2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "caja_ahorro")
@PrimaryKeyJoinColumn(name = "numero_cuenta")
public class CajaAhorro extends Cuenta {

	private Float intereses;

	public CajaAhorro() {
	}

	@Column(name = "intereses")
	public Float getIntereses() {
		return intereses;
	}

	public void setIntereses(Float intereses) {
		this.intereses = intereses;
	}

	@Override
	public String toString() {
		return "Tipo Cuenta : Caja de Ahorro " + " saldo : " + getSaldo() + " intereses :" + getIntereses();
	}

}
