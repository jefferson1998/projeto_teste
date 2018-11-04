package ifpe.edu.smbg.model.dao;

import ifpe.edu.smbg.model.entity.PrestacaoDeConta;


public interface PrestacaoDeContaDAO extends DAO<PrestacaoDeConta> {

	public PrestacaoDeConta buscarPeloCpfDoFuncionario(String cpf);

	public PrestacaoDeConta buscarPelaIdentidadeDoFuncionario(String numeroIdentidade);

	public PrestacaoDeConta buscarPelaCnhDoFuncionario(String cnh);

}
