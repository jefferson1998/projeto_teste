package ifpe.edu.smbg.model;

import ifpe.edu.smbg.model.dao.DAO;
import ifpe.edu.smbg.model.dao.FuncionarioDAO;
import ifpe.edu.smbg.model.dao.FuncionarioHibernate;
import ifpe.edu.smbg.model.entity.Funcionario;

import java.util.List;

public class FuncionarioModel {

   private DAO<Funcionario> daoFuncionario = new FuncionarioHibernate();
    
    public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
        if (buscarFuncionarioPeloCpf(funcionario.getCpf()) == null) {
            funcionario.setSenha(funcionario.getCpf().substring(9,11) + "" + funcionario.getCpf().substring(12,funcionario.getCpf().length()));
            daoFuncionario.inserir(funcionario);
        } else {
            throw new Exception("CPF já cadastrado!");
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) throws Exception{
        if (buscarFuncionarioPeloCpf(funcionario.getCpf()) != null) {
            daoFuncionario.atualizar(funcionario);
        } else {
            throw new Exception("Funcionario não cadastrado!");
        }
    }

    public void removerFuncionario(Funcionario funcionario) {
        daoFuncionario.deletar(funcionario);
    }

    public List<Funcionario> buscaTodosOsFuncionarios() {
        return daoFuncionario.listarTodos();
    }

    public Funcionario buscarFuncionarioPeloCpf(String cpf) {
        return ((FuncionarioDAO) daoFuncionario).buscarPeloCpf(cpf);
    }

    public Funcionario buscarFuncionarioPelaIdentidade(String numeroIdentidade) throws Exception {
    	if(numeroIdentidade == null) {
    		throw new Exception("Número do RG vazio!");
    	} else {
            return ((FuncionarioDAO) daoFuncionario).buscarPelaIdentidade(numeroIdentidade);
    	}
    }

    public Funcionario buscarFuncionarioPelaCnh(String cnh) throws Exception  {
    	if (cnh == null) {
    		throw new Exception("CNH vazia!");
    	} else {
            return ((FuncionarioDAO) daoFuncionario).buscarPelaCnh(cnh);
    	}
    }

}
