package ifpe.edu.smbg.model.dao;

import java.util.List;

public interface DAO <T> {
	public void inserir ( T objeto );
	public void atualizar ( T objeto ) ;
	public void deletar ( T objeto ) ;
	public List<T> listarTodos();
	
}
