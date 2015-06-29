/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.modelo;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Jose Alves
 */
@Entity
public class Banca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoBanca;
    
    @ManyToMany
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
