/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.controller;

import br.com.dedoduro.base.ConcursoDAO;
import br.com.dedoduro.modelo.Concurso;
import br.com.dedoduro.util.Util;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Cleanup;

/**
 *
 * @author Jose Alves
 */
@ManagedBean
@RequestScoped
public class ConcursoMB {
    
    private static String PAGINA_DESCRICAO = "descricaoConcurso";
    
    Concurso concurso = null;
    
    public ConcursoMB() {
        concurso = Util.captarConcursoSessao();
        if (Util.isEmpty( concurso )) {
            concurso = new Concurso();
        }
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
        String codConcurso = (String) FacesContext.getCurrentInstance().
                             getExternalContext().getRequestParameterMap().get("codConcurso");
        
        @Cleanup
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
        @Cleanup
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        ConcursoDAO dao = new ConcursoDAO(entityManager);
        setConcurso( (Concurso) dao.selectByCodigo( "codigoConcurso", Long.parseLong(codConcurso) ) );

        Util.gravarConcursoSessao( getConcurso() );
        
        return PAGINA_DESCRICAO;
    }
}
