/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.modelo;

import br.com.dedoduro.framework.persistence.DomainObject;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jose Alves
 */
@Entity
public class Usuario extends DomainObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoUsuario;
    
    @NotNull
    private String email;
    
    @NotNull
    private String senha;
    
    @NotNull
    private String receberEmail; // S - Sim; N - Nao;
    
    @ManyToMany
    private LinkedList<Banca> bancas;
    
    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getReceberEmail() {
        return receberEmail;
    }

    public void setReceberEmail(String receberEmail) {
        this.receberEmail = receberEmail;
    }

    public LinkedList<Banca> getBancas() {
        if (bancas == null) {
            bancas = new LinkedList<Banca>();
        }
        return bancas;
    }

    public void setBancas(LinkedList<Banca> bancas) {
        this.bancas = bancas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
