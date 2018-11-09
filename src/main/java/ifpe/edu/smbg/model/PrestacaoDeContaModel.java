package ifpe.edu.smbg.model;

import ifpe.edu.smbg.dao.DAO;
import ifpe.edu.smbg.dao.PrestacaoDeContaDAO;
import ifpe.edu.smbg.dao.PrestacaoDeContaHibernate;
import ifpe.edu.smbg.model.entity.PrestacaoDeConta;

import java.util.List;

public class PrestacaoDeContaModel {
	
	private DAO<PrestacaoDeConta> daoPrestacaoDeConta = new PrestacaoDeContaHibernate();
        
	public void cadastrarPrestacaoDeConta(PrestacaoDeConta prestacaoDeConta) {
		daoPrestacaoDeConta.inserir(prestacaoDeConta);
	}
	
	public void atualizarPrestacaoDeConta(PrestacaoDeConta prestacaoDeConta) {
		daoPrestacaoDeConta.atualizar(prestacaoDeConta);
	}
	
	public void removerPrestacaoDeConta(PrestacaoDeConta prestacaoDeConta) {
		daoPrestacaoDeConta.deletar(prestacaoDeConta);
	}
	
	public List<PrestacaoDeConta> buscaTodasAsPrestacoesDeConta() {
		return daoPrestacaoDeConta.listarTodos();
	}
	
	public PrestacaoDeConta buscarPrestacaoDeContaPeloCpfDoFuncionario(String cpf) {
		return ((PrestacaoDeContaDAO) daoPrestacaoDeConta).buscarPeloCpfDoFuncionario(cpf);
	}

	public PrestacaoDeConta buscarAdmissaoPelaIdentidadeDoFuncionario(String numeroIdentidade) {
		return ((PrestacaoDeContaDAO) daoPrestacaoDeConta).buscarPelaIdentidadeDoFuncionario(numeroIdentidade);
	}

	public PrestacaoDeConta buscarAdmissaoPelaCnhDoFuncionario(String cnh) {
		return ((PrestacaoDeContaDAO) daoPrestacaoDeConta).buscarPelaCnhDoFuncionario(cnh);
	}
}
