package ifpe.edu.smbg.controller;

import ifpe.edu.smbg.model.SeguroOnibusModel;
import ifpe.edu.smbg.model.entity.Onibus;
import ifpe.edu.smbg.model.entity.SeguroOnibus;

import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class ControllerSeguroOnibusSMBG {
    SeguroOnibus seguroOnibus;
    SeguroOnibusModel seguroModel;
    List<SeguroOnibus> listaSeguro;
    int codigoSusepDoCorretor;
    
    public ControllerSeguroOnibusSMBG() {
        seguroModel  = new SeguroOnibusModel();
        seguroOnibus = new SeguroOnibus();
    }
    
    public void cadastrarSeguro() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            seguroModel.cadastrarSeguroOnibus(seguroOnibus);
            listaTodos();
            seguroOnibus = new SeguroOnibus();
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public List<SeguroOnibus> listaTodos(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaSeguro = seguroModel.listarTodoOsSegurosDosOnibus();
            Collections.sort(listaSeguro);
            return listaSeguro;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        
        return listaSeguro;
    }
    
    public void removerSeguro() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            seguroModel.removerSeguroOnibus(seguroOnibus);
            listaTodos();
            seguroOnibus = new SeguroOnibus();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        
    }
    
    public void alterarSeguro() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            seguroModel.atualizarSeguroOnibus(seguroOnibus);
            listaTodos();
            seguroOnibus = new SeguroOnibus();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        
    }
    
    public SeguroOnibus buscarSeguroPeloCodigoSusepDoCorretor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            seguroOnibus = seguroModel.buscarSeguroDoOnibusPeloCodigoCpdDoCorretor(codigoSusepDoCorretor);
            return seguroOnibus;
        } catch (Exception ex) {
            seguroOnibus = null;
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return seguroOnibus;
    }

    public int getCodigoSusepDoCorretor() {
        return codigoSusepDoCorretor;
    }

    public void setCodigoSusepDoCorretor(int codigoSusepDoCorretor) {
        this.codigoSusepDoCorretor = codigoSusepDoCorretor;
    }
    
    public SeguroOnibus getSeguroOnibus() {
        return seguroOnibus;
    }

    public void setSeguroOnibus(SeguroOnibus seguroOnibus) {
        this.seguroOnibus = seguroOnibus;
    }
}
