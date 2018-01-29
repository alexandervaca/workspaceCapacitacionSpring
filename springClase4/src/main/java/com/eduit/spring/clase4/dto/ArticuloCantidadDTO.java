package com.eduit.spring.clase4.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


@Entity
@Table(name="articulos")
public class ArticuloCantidadDTO implements Serializable {
	
   
	private static final long serialVersionUID = 1L;
	
	private Long id;

	@NumberFormat(style = Style.NUMBER)
	@Min(1)
	@Max(9999)
	private Integer cantidad;
	
	

	public ArticuloCantidadDTO(String nombre, String presentacion, Float precio, Integer cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public ArticuloCantidadDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
