/*
 * Poliza.java
 *
 * Created on 17 de noviembre de 2008, 15:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.eduit.spring.clase2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="poliza")
public class Poliza implements Serializable {
    
    private Long id;
    private String textoPoliza;
    private Seguro seguro;
    
    
    public Poliza() {
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="poliza_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="texto")
    public String getTextoPoliza() {
        return textoPoliza;
    }

    public void setTextoPoliza(String textoPoliza) {
        this.textoPoliza = textoPoliza;
    }
    
    @OneToOne(mappedBy="poliza")
    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
  
    
    
    
}
