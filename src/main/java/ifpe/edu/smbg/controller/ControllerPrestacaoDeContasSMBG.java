package ifpe.edu.smbg.controller;

import ifpe.edu.smbg.model.PrestacaoDeContaModel;
import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.PrestacaoDeConta;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ControllerPrestacaoDeContasSMBG {

    private PrestacaoDeConta prestacaoDeConta;
    private Funcionario funcionarioQuePrestouConta;
    private PrestacaoDeContaModel prestacaoDeContaModel;
    private List<PrestacaoDeConta> listaTodasAsPrestacoes;
    private String cpf;

    public ControllerPrestacaoDeContasSMBG() {
        prestacaoDeConta = new PrestacaoDeConta();
        prestacaoDeContaModel = new PrestacaoDeContaModel();

        prestacaoDeConta.setValorTotalDoCombustivel(
                prestacaoDeConta.getValorDoLitroDeCombustivel() * prestacaoDeConta.getQuantidadeDeLitrosAbastecido());

        prestacaoDeConta.setValorArrecadadoDescontado(
                prestacaoDeConta.getValorTotalArrecadadoNoDia() - prestacaoDeConta.getValorTotalDoCombustivel()
                - prestacaoDeConta.getSalarioDoMotorista() - prestacaoDeConta.getSalarioDoCobrador());

        funcionarioQuePrestouConta = null; //Pegar o nome do funcionario logado na sessao
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public PrestacaoDeConta getPrestacaoDeConta() {
        return prestacaoDeConta;
    }

    public void setPrestacaoDeConta(PrestacaoDeConta prestacaoDeConta) {
        this.prestacaoDeConta = prestacaoDeConta;
    }

    public Funcionario getFuncionarioQuePrestouConta() {
        return funcionarioQuePrestouConta;
    }

    public void setFuncionarioQuePrestouConta(Funcionario funcionarioQuePrestouConta) {
        this.funcionarioQuePrestouConta = funcionarioQuePrestouConta;
    }

    public void cadastrarPrestacaoDeConta() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            prestacaoDeContaModel.cadastrarPrestacaoDeConta(prestacaoDeConta);
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }
    
    public PrestacaoDeConta buscarFuncionarioPeloCPF() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            prestacaoDeConta = prestacaoDeContaModel.buscarPrestacaoDeContaPeloCpfDoFuncionario(cpf);
            context.addMessage(null, new FacesMessage("Busca Efetuada!"));
            return prestacaoDeConta;
        } catch (Exception ex) {
            prestacaoDeConta = null;
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
        return prestacaoDeConta;
    }

    public void removerPrestacaoDeConta() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            prestacaoDeContaModel.removerPrestacaoDeConta(prestacaoDeConta);
            context.addMessage(null, new FacesMessage("Remoção Efetuada!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void atualizarPrestacaoDeConta() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            prestacaoDeContaModel.atualizarPrestacaoDeConta(prestacaoDeConta);
            context.addMessage(null, new FacesMessage("Atualização Efetuada!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public List<PrestacaoDeConta> listaTodos() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            listaTodasAsPrestacoes = prestacaoDeContaModel.buscaTodasAsPrestacoesDeConta();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

        return listaTodasAsPrestacoes;
    }

}
