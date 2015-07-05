/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jose Alves
 */
@Entity
public class Link {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoLink;
    
    private String url;
    private int contadorLogico;

    public Long getCodigoLink() {
        return codigoLink;
    }

    public void setCodigoLink(Long codigoLink) {
        this.codigoLink = codigoLink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getContadorLogico() {
        return contadorLogico;
    }

    public void setContadorLogico(int contadorLogico) {
        this.contadorLogico = contadorLogico;
    }
    
}
