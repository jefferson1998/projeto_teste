/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.smbg.controller;

import ifpe.edu.smbg.model.RotaModel;
import ifpe.edu.smbg.model.entity.Rota;

import java.util.Collections;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jessin
 */
@ManagedBean
@SessionScoped
public class ControllerRotaSMBG {

    Rota rota;
    RotaModel rotaModel;
    List<Rota> listaRota;
    List<Rota> listaDeBusca;
    String origem;

    public ControllerRotaSMBG() {
        rota = new Rota();
        rotaModel = new RotaModel();

    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void cadastrarRota() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            rotaModel.cadastrarRota(rota);
            listaTodos();
            rota = new Rota();
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

    }

    public void removerRota() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            rotaModel.removerRota(rota);
            listaTodos();
            rota = new Rota();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

    }

    public void atualizarRota() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            rotaModel.atualizarRota(rota);
            listaTodos();
            rota = new Rota();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public List<Rota> listaTodos() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaRota = rotaModel.listarTodasAsRotas();
            Collections.sort(listaRota);
            return listaRota;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return null;
    }
    
     public List<Rota>  buscarPelaOrigemDaRota() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaDeBusca = rotaModel.buscarPelaOrigem(origem);
            return listaDeBusca;
        } catch (Exception ex) {
            listaDeBusca = null;
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return listaDeBusca;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public List<Rota> getListaDeBusca() {
        return listaDeBusca;
    }

    public void setListaDeBusca(List<Rota> listaDeBusca) {
        this.listaDeBusca = listaDeBusca;
    }
     
}
