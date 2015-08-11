/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dedoduro.controller;

import br.com.dedoduro.base.UsuarioDAO;
import br.com.dedoduro.modelo.Usuario;
import br.com.dedoduro.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
public class UsuarioMB implements Serializable {

    private Usuario usuario = new Usuario();
    private Collection<Usuario> listaUsuario = new ArrayList<>();
    
    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Usuario> getListaUsuario() {
        if (listaUsuario == null) {
            return new ArrayList<Usuario>();
        }
    
        return listaUsuario;
    }

    public void setListaUsuario(Collection<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    /**
     * Responsavel por persistir as informacoes digitadas na base
     */
    public void salvarUsuario() {
        
        @Cleanup
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
        @Cleanup
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        UsuarioDAO dao = new UsuarioDAO(entityManager);
        getUsuario().setSenha( Util.cifrar( getUsuario().getSenha() ) );
        Usuario usInserido = dao.insert( getUsuario() );
        entityManager.getTransaction().commit();
    }
    
}
