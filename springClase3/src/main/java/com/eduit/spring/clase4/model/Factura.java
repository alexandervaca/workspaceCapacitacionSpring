package com.eduit.spring.clase4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "factura")
public class Factura {

	private Long id;
	
	@NotEmpty
	private String cliente;// obligatorio
	
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	@Min(1)
	@Max(999999)
	private Integer numero;// numero obligatorio maximo 999999
	
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	private Float monto;// numerico obligatorio

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "cliente")
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Column(name = "numero")
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name = "monto")
	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

}
