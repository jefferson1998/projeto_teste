package ifpe.edu.smbg.model;

import ifpe.edu.smbg.dao.DAO;
import ifpe.edu.smbg.dao.OnibusDAO;
import ifpe.edu.smbg.dao.OnibusHibernate;
import ifpe.edu.smbg.model.entity.Onibus;

import java.util.List;

public class OnibusModel {
	
	private DAO<Onibus> daoOnibus = new OnibusHibernate();
	
	public void cadastrarOnibus(Onibus onibus) {
		daoOnibus.inserir(onibus);
	}
	
	public void removerOnibus(Onibus onibus) {
		daoOnibus.deletar(onibus);
	}
	
	public void atualizarOnibus(Onibus onibus) {
		daoOnibus.atualizar(onibus);
	}
	
	public List<Onibus> listarTodosOsOnibus() {
		return daoOnibus.listarTodos();
	}
	
	public Onibus buscarPeloOnibusPeloCodigoRenavam(String codigoRenavam) {
		return ((OnibusDAO) daoOnibus).buscarPeloOnibusPeloCodigoRenavam(codigoRenavam);
	}


	public Onibus buscarPeloOnibusChassis(String chassi) {
		return ((OnibusDAO) daoOnibus).buscarPeloOnibusChassis(chassi);
		
	}

	
	public Onibus buscarPelaOnibusPlaca(String placa) {
		return ((OnibusDAO) daoOnibus).buscarPelaOnibusPlaca(placa);
		
	}

}
