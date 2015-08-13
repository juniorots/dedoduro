package br.com.dedoduro.controller;

import br.com.dedoduro.base.UsuarioDAO;
import br.com.dedoduro.modelo.Usuario;
import br.com.dedoduro.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Cleanup;
import org.primefaces.context.RequestContext;

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
        
        FacesMessage mensagem = null;
        
        if ( !continuarRegistro( getUsuario() ) ) {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no cadastro. E-mail já registrado no sistema.", "");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return;
        }
        
        @Cleanup
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
        @Cleanup
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        UsuarioDAO dao = new UsuarioDAO(entityManager);
        getUsuario().setSenha( Util.cifrar( getUsuario().getSenha() ) );
        Usuario usInserido = dao.insert( getUsuario() );
        entityManager.getTransaction().commit();
        
        if ( !Util.isEmpty( usInserido.getCodigoUsuario() ) ) {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Status", "Usuário cadastrado com sucesso.");
            Util.gravarUsuarioSessao( usInserido );
            usuario = new Usuario();
        } else {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status", "Falha no cadastro. Operação cancelada.");
        }
        RequestContext.getCurrentInstance().showMessageInDialog(mensagem);
    }
    
    /**
     * Responsavel por verificar se o e-mail ja nao esta inserido na base de dados
     * @param usuario
     * @return 
     */
    private boolean continuarRegistro(Usuario usuario) {
        
        @Cleanup
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
        @Cleanup
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        UsuarioDAO dao = new UsuarioDAO(entityManager);
        
        if ( !Util.isEmpty( dao.findByStringField("email", usuario.getEmail(), true, 1, 1) ) ) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Credenciando usuario
     */
    public void validarUsuario() {
        
    }
}
