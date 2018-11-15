package ifpe.edu.teste_funcionario;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.HibernateException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.controller.ControllerFuncionarioSMBG;
import ifpe.edu.smbg.model.entity.Funcionario;

class remocaoDoFuncionario {

	static Funcionario f = new Funcionario();
	private static ControllerFuncionarioSMBG cf = new ControllerFuncionarioSMBG();

	@BeforeAll
	public static void criandoFuncionario() {
		f = cf.buscarFuncionarioPeloCPF("125.225.945/10");
		cf.setFuncionario(f);
	}
	
	@Test
	void testRemoverFuncionario() {
		try {
			cf.removerFuncionario();	
			assertNull(cf.buscarFuncionarioPeloCPF("125.225.945/10"));
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}

}
