package ifpe.edu.smbg.controller;

import ifpe.edu.smbg.model.OnibusModel;
import ifpe.edu.smbg.model.entity.Onibus;

import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

public class ControllerOnibusSMBG {
    OnibusModel onibusModel;
    Onibus onibus;
    List<Onibus> listaOnibus;
    List<Onibus> listaOnibusBuscar;
    private String buscarOnibus;

    public ControllerOnibusSMBG() {
        onibusModel = new OnibusModel();
        onibus = new Onibus();
        buscarOnibus = "";
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }
    
    public String getBuscarOnibus() {
        return buscarOnibus;
    }

    public void setBuscarOnibus(String buscarOnibus) {
        this.buscarOnibus = buscarOnibus;
    }

    public void cadastrarOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibusModel.cadastrarOnibus(onibus);
            listaTodos();
            onibus = new Onibus();
        context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void alterarOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibusModel.atualizarOnibus(onibus);
            listaTodos();
            onibus = new Onibus();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void removerOnibus() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibusModel.removerOnibus(onibus);
            listaTodos();
            onibus = new Onibus();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public List<Onibus> listaTodos() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibusModel = new OnibusModel();
            listaOnibus = onibusModel.listarTodosOsOnibus();
            Collections.sort(listaOnibus);
            return listaOnibus;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return null;
    }
    
    public Onibus buscarOnibusPelaPlaca() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibus = onibusModel.buscarPelaOnibusPlaca(buscarOnibus);
            context.addMessage(null, new FacesMessage("Buscar efetuada!"));
            return onibus;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
            return null;
        }
    }

     public Onibus buscarOnibusPeloChassi() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibus = onibusModel.buscarPeloOnibusChassis(buscarOnibus);
            context.addMessage(null, new FacesMessage("Buscar efetuada!"));
            return onibus;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
            return null;
        }
    }
     
     public Onibus buscarOnibusPeloCodigoRenavam() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            onibus = onibusModel.buscarPeloOnibusPeloCodigoRenavam(buscarOnibus);
            context.addMessage(null, new FacesMessage("Buscar efetuada!"));
            return onibus;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
            return null;
        }
    }

    public List<Onibus> getListaOnibusBuscar() {
        return listaOnibusBuscar;
    }

    public void setListaOnibusBuscar(List<Onibus> listaOnibusBuscar) {
        this.listaOnibusBuscar = listaOnibusBuscar;
    }

}
