/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.controller;

import br.com.dedoduro.modelo.Concurso;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jose Alves
 */
@ManagedBean
@RequestScoped
public class ConcursoMB {
    
    private Collection<Concurso> listaCespe;
    
    public ConcursoMB() {
    }

    public Collection<Concurso> getListaCespe() {
        return listaCespe;
    }

    public void setListaCespe(Collection<Concurso> listaCespe) {
        this.listaCespe = listaCespe;
    }
    
    /**
     * Carregamento de lista com limite de registros
     * prezando pela estetica da pagina
     * @return 
     */
    public Collection<Concurso> carregarListaCespe() {
        Collection<Concurso> retorno = new ArrayList();
        
        return retorno;
    }
}
