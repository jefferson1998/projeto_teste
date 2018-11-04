/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.smbg.controller;

import ifpe.edu.smbg.model.FuncionarioModel;
import ifpe.edu.smbg.model.IteratorFuncionario;
import ifpe.edu.smbg.model.entity.Funcionario;

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
public class ControllerFuncionarioSMBG {

    private Funcionario funcionario;
    private FuncionarioModel funcionarioModel;
    private List<Funcionario> listaFuncionario;
    private String cpf,rg, cnh;

    public ControllerFuncionarioSMBG() {
        funcionario = new Funcionario();
        funcionarioModel = new FuncionarioModel();
    }
    

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void cadastrarFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            funcionarioModel.cadastrarFuncionario(funcionario);
            funcionario = new Funcionario();
            listaTodos();
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

    }

    public void removerFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            funcionarioModel.removerFuncionario(funcionario);
            listaTodos();
            context.addMessage(null, new FacesMessage("Remoção Efetuada!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

    }
    
    public void alterarFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            funcionarioModel.atualizarFuncionario(funcionario);
            listaTodos();
            context.addMessage(null, new FacesMessage("Alteração Efetuada!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

    }
    
    public Funcionario buscarFuncionarioPeloCPF() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            funcionario = funcionarioModel.buscarFuncionarioPeloCpf(cpf);
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
            context.addMessage(null, new FacesMessage("Erro ao procurar!"));
        }
        return funcionario;
    }
    
    public Funcionario buscarFuncionarioPeloCNH() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            funcionario = funcionarioModel.buscarFuncionarioPelaCnh(cnh);
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
            context.addMessage(null, new FacesMessage("Erro ao procurar!"));
        }
        return funcionario;
    }
    
    public Funcionario buscarFuncionarioPeloRG() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            funcionario = funcionarioModel.buscarFuncionarioPelaIdentidade(rg);
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
            context.addMessage(null, new FacesMessage("Erro ao procurar!"));
        }
        return funcionario;
    }

    public List<Funcionario> listaTodos() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaFuncionario = funcionarioModel.buscaTodosOsFuncionarios();
            Collections.sort(listaFuncionario);
            funcionario = new Funcionario();
            return listaFuncionario;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return null;
    }

    public int totalDeMotoristas() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaFuncionario = funcionarioModel.buscaTodosOsFuncionarios();

            int contador = 0;
            IteratorFuncionario iteratorFuncionario = new IteratorFuncionario(listaFuncionario);
            while (iteratorFuncionario.hasNext()) {
                if (iteratorFuncionario.next().getAdmissao().getFuncao().equals("Motorista")) {
                    contador++;
                }
            }
            return contador;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return 0;
    }

    public int totalDeCobradores() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaFuncionario = funcionarioModel.buscaTodosOsFuncionarios();

            int contador = 0;
            IteratorFuncionario iteratorFuncionario = new IteratorFuncionario(listaFuncionario);
            while (iteratorFuncionario.hasNext()) {
                if (iteratorFuncionario.next().getAdmissao().getFuncao().equals("Cobrador")) {
                    contador++;
                }
            }
            return contador;
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return 0;
    }
    
    public static Funcionario buscarFuncionarioPeloCpfParaLogin(String cpf) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            return new FuncionarioModel().buscarFuncionarioPeloCpf(cpf);
             
        } catch (Exception erro) {
            
            context.addMessage(null, new FacesMessage("Erro ao procurar!"));
        }
        return null;
    }

   
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

}
