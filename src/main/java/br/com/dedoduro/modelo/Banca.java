/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.modelo;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jose Alves
 */
@Entity
public class Banca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoBanca;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "codigoLink")
    private LinkedList<Link> links;

    public Long getCodigoBanca() {
        return codigoBanca;
    }

    public void setCodigoBanca(Long codigoBanca) {
        this.codigoBanca = codigoBanca;
    }

    public LinkedList<Link> getLinks() {
        return links;
    }

    public void setLinks(LinkedList<Link> links) {
        this.links = links;
    }
    
}
