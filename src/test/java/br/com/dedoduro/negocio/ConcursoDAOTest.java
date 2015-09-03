/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.negocio;

import br.com.dedoduro.base.BancaDAO;
import br.com.dedoduro.base.ConcursoDAO;
import br.com.dedoduro.modelo.Banca;
import br.com.dedoduro.modelo.Concurso;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Cleanup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jose Alves
 */
public class ConcursoDAOTest {
    public ConcursoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }   

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mainTest(){
    }
    
    public Collection<Concurso> inserirConcursos(String banca) {
        Collection<Concurso> retorno = new ArrayList();
        
        @Cleanup
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");

        @Cleanup
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        Concurso concurso = new Concurso();
        ConcursoDAO daoConcurso = new ConcursoDAO(entityManager);
        
        if ( banca.equals("cespe") ) {
            concurso.setNomeConcurso("Ministério do Planejamento, Orçamento e Gestão");
            concurso.setUrlImagem("mpog.jpg");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("Ministério da Educação");
            concurso.setUrlImagem("mec.jpg");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        if ( banca.equals("cesgranrio") ) {
            concurso.setNomeConcurso("Banco da Amazônia S.A");
            concurso.setUrlImagem("bcoAmazonia.jpg");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("Liquigás Distribuidora S.A");
            concurso.setUrlImagem("liguigas.jpg");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        if ( banca.equals("fcc") ) {
            concurso.setNomeConcurso("TRT 15ª Região - Campinas/SP");
            concurso.setUrlImagem("trt15.jpg");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("METRÔ - São Paulo");
            concurso.setUrlImagem("metro.png");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        if ( banca.equals("quadrix") ) {
            concurso.setNomeConcurso("BB Tecnologia e Serviços");
            concurso.setUrlImagem("bbservicos.jpg");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("Conselho Regional de Educação Física");
            concurso.setUrlImagem("cref.jpg");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        if ( banca.equals("marinha") ) {
            concurso.setNomeConcurso("CPA-CAP");
            concurso.setUrlImagem("marinha.jpg");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("Escola Naval - CPAEN");
            concurso.setUrlImagem("escNaval.jpg");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        if ( banca.equals("exercito") ) {
            concurso.setNomeConcurso("EsPCEx");
            concurso.setUrlImagem("espcex.jpg");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("ESFCEX");
            concurso.setUrlImagem("esfcex.jpg");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        if ( banca.equals("aeronautica") ) {
            concurso.setNomeConcurso("EEAR");
            concurso.setUrlImagem("eear.png");
            Concurso concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);

            concurso = new Concurso();
            concurso.setNomeConcurso("EPCAR");
            concurso.setUrlImagem("epcar.jpg");
            concursoInserido = daoConcurso.insert(concurso);
            retorno.add(concursoInserido);
            
            entityManager.getTransaction().commit();
        }
        
        return retorno;
    }
}
