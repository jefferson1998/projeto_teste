package ifpe.edu.smbg.model.dao;

import ifpe.edu.smbg.model.entity.Onibus;


public interface OnibusDAO extends DAO<Onibus> {

	public Onibus buscarPeloOnibusPeloCodigoRenavam(String codigoRenavam);
	
	public Onibus buscarPeloOnibusChassis(String chassi);
	
	public Onibus buscarPelaOnibusPlaca(String placa);
	
}
