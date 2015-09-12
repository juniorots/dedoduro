/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.controller;

import br.com.dedoduro.modelo.Concurso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jose Alves
 */
@ManagedBean
@RequestScoped
public class ConcursoMB {
    
    private static String PAGINA_DESCRICAO = "descricaoConcurso";
    
    Concurso concurso = new Concurso();
    
    public ConcursoMB() {
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }
    
    /**
     * Carregara a descricao do concurso
     * selecionado
     */
    public String carregarCaracteristica() {
        return PAGINA_DESCRICAO;
    }
}
