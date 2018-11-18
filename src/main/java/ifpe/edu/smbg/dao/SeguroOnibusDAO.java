package ifpe.edu.smbg.dao;

import ifpe.edu.smbg.model.entity.SeguroOnibus;


public interface SeguroOnibusDAO extends DAO<SeguroOnibus> {
	
	public SeguroOnibus buscarPeloCodigoSusepDoCorretor (int codigoSusepDoCorretor);
	
	public SeguroOnibus buscarPeloCodigoCpdDoCorretor (int codigoCpdDoCorretor);
	
	public SeguroOnibus buscarPeloCodigoSusep (int codigoSusep);
	
	public SeguroOnibus buscarPeloCnpjDaEmpresaDoSeguro (String cpnj);
	
	public SeguroOnibus buscarPeloCpfOuCnpjDoSegurado (String cpfOuCnpjDoSegurado);
	
	public SeguroOnibus buscarPeloNumeroEndosso (int numeroEndosso);
	
}
