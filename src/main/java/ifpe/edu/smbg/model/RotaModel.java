package ifpe.edu.smbg.model;

import ifpe.edu.smbg.model.dao.DAO;
import ifpe.edu.smbg.model.dao.RotaDAO;
import ifpe.edu.smbg.model.dao.RotaHibernate;
import ifpe.edu.smbg.model.entity.Rota;

import java.util.List;

public class RotaModel {
	
	private DAO<Rota> rotaDAO = new RotaHibernate();
	
	public void cadastrarRota (Rota rota) {
		rotaDAO.inserir(rota);
	}
	
	public void atualizarRota (Rota rota) {
		rotaDAO.atualizar(rota);
	}
	
	public void removerRota(Rota rota) {
		rotaDAO.deletar(rota);
	}

	
	public List<Rota> listarTodasAsRotas() {
		return rotaDAO.listarTodos();
	}

	
	public List<Rota> buscarPelaOrigem(String origem) {
		return ((RotaDAO) rotaDAO).buscarPelaOrigem(origem);
	}

	
	public List<Rota> buscarPeloDestino(String destino) {
		return ((RotaDAO) rotaDAO).buscarPeloDestino(destino);
	}

	
	public List<Rota> buscarPeloHorarioDeSaida(String horarioDeSaida) {
		return ((RotaDAO) rotaDAO).buscarPeloHorarioDeSaida(horarioDeSaida);
	}

}
