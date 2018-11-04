package ifpe.edu.smbg.controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ifpe.edu.smbg.model.entity.Usuario;

@ManagedBean
@SessionScoped
public class ControllerPaginaAdminitrador {
    
    public Usuario sessionUsuario;
    
    public void checkUsuarioSession() throws IOException{
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioID") != null){
            int sessionUsuarioID = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioID").toString());
            if(sessionUsuario == null)
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SMBG/");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SMBG/");
        }
    }
    
    
    
    public void irPaginaOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("PaginaOnibus.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irPaginaSeguroOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("PaginaSeguroOnibus.xhtml");
        } catch (IOException e) {

        }
    }
    
     public void irPaginaAdmin() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("PaginaAdmin.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irCadastrarOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastrarOnibusSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irBuscarOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("BuscaOnibusSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irBuscarSeguro() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("BuscaSeguroSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irBuscarRota() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("BuscaRotaSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irBuscarFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("BuscaFuncionarioSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
    
    public void irPaginaFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("PaginaFuncionario.xhtml");
        } catch (IOException e) {

        }
    }
    
     public void irPaginaBuscarFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("BuscaFuncionarioSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
    
    
    public void irCadastrarFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastrarFuncionarioSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
     public void irCadastrarSeguroOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastrarSeguroSMBG.xhtml");
        } catch (IOException e) {

        }
    }
    
     public void irPaginaRota() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("PaginaRota.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void irCadastrarRota() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastrarRotaSMBG.xhtml");
        } catch (IOException e) {

        }
    }

   
    
    public Usuario getSessionUsuario() {
        return sessionUsuario;
    }
    
    
}
