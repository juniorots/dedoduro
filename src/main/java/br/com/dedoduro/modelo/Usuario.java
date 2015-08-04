/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.modelo;

import br.com.dedoduro.framework.persistence.DomainObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
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
    private String nome;
    
    @NotNull
    private String email;
    
    @NotNull
    private String senha;
    
    @Temporal(DATE)
    @NotNull
    private Date dtNascimento;
    
    @NotNull
    private String receberEmail; // S - Sim; N - Nao;
    
    @ManyToMany (fetch=FetchType.LAZY)
    @JoinColumn(name = "codigoBanca")
    private Collection<Banca> bancas;
    
    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getReceberEmail() {
        return receberEmail;
    }

    public void setReceberEmail(String receberEmail) {
        this.receberEmail = receberEmail;
    }

    public Collection<Banca> getBancas() {
        if (bancas == null) {
            bancas = new ArrayList<Banca>();
        }
        return bancas;
    }

    public void setBancas(ArrayList<Banca> bancas) {
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
