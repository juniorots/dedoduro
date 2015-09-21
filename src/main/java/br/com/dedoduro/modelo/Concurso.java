/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.modelo;

import br.com.dedoduro.framework.persistence.DomainObject;
import javax.persistence.Entity;

/**
 *
 * @author Jose Alves
 */
@Entity
public class Concurso extends DomainObject {
    
    private String nomeConcurso;
    private String urlImagem;
    private String url;
    
    private int contadorLogico;

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

    public String getNomeConcurso() {
        return nomeConcurso;
    }

    public void setNomeConcurso(String nomeConcurso) {
        this.nomeConcurso = nomeConcurso;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
