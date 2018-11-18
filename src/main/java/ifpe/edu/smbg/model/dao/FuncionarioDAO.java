package ifpe.edu.smbg.model.dao;

import ifpe.edu.smbg.model.entity.Funcionario;


public interface FuncionarioDAO extends DAO<Funcionario> {

	public Funcionario buscarPeloCpf(String cpf);

	public Funcionario buscarPelaIdentidade(String numeroIdentidade);

	public Funcionario buscarPelaCnh(String cnh);

}
