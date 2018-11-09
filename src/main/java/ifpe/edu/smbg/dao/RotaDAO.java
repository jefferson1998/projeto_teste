package ifpe.edu.smbg.dao;

import ifpe.edu.smbg.dao.DAO;
import ifpe.edu.smbg.model.entity.Rota;

import java.util.List;

public interface RotaDAO extends DAO<Rota> {
	
	public List<Rota> buscarPelaOrigem(String origem);
	
	public List<Rota> buscarPeloDestino(String destino);
	
	public List<Rota> buscarPeloHorarioDeSaida(String horarioDeSaida);
	

}
