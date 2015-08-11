/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.controller;

import br.com.dedoduro.modelo.Banca;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author Jose Alves
 */
@ManagedBean
@RequestScoped
public class BancaMB {

    private Banca banca = new Banca();
    private Collection<Banca> listaBanca  = new ArrayList<>();
    
    /**
     * Creates a new instance of BancaMB
     */
    public BancaMB() {
    }

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public Collection<Banca> getListaBanca() {
        if (listaBanca == null) {
            return new ArrayList<Banca>();
        }
        return listaBanca;
    }

    public void setListaBanca(Collection<Banca> listaBanca) {
        this.listaBanca = listaBanca;
    }
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Ativado", event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Desativado", event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
