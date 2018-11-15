package ifpe.edu.teste_funcionario;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.controller.ControllerFuncionarioSMBG;
import ifpe.edu.smbg.model.entity.Funcionario;

class buscaDoFuncionario {
	static Funcionario f = new Funcionario();
	private static ControllerFuncionarioSMBG cf = new ControllerFuncionarioSMBG();

	@BeforeAll
	public static void criandoFuncionario() {
		f = cf.buscarFuncionarioPeloCPF("125.225.945/00");
	}
	
	@Test
	void testBuscandoFuncionarioPeloCPFNull() {
		try {
			Funcionario fu = cf.buscarFuncionarioPeloCPF("125.335.954-70");
			assertNull(fu);
			fu = cf.buscarFuncionarioPeloCPF(null);
			assertNull(fu);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testBuscandoFuncionarioPeloCPFNotNull() {
		try {
			assertNotNull(f);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testBuscandoFuncionarioPeloCPFEquals() {
		try {
			Funcionario fu = cf.buscarFuncionarioPeloCPF("125.225.945/00");
			assertEquals(fu, f);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testBuscandoFuncionarioPeloRGNull() {
		try {
			Funcionario fu = cf.buscarFuncionarioPeloRG("0");
			assertNull(fu);
			fu = cf.buscarFuncionarioPeloRG(null);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testBuscandoFuncionarioPeloRGNotNull() {
		try {
			Funcionario fu = cf.buscarFuncionarioPeloRG("17");
			assertNotNull(fu);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testBuscandoFuncionarioPeloRGEquals() {
		try {
			Funcionario fu = cf.buscarFuncionarioPeloRG(null);
			assertEquals(fu, null);
			fu = cf.buscarFuncionarioPeloRG("17");
			assertEquals(fu, f);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testBuscandoTodosFuncionarios() {
		try {
			List<Funcionario> funcionarios = cf.listaTodos();
			assertNotNull(funcionarios);
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTotalDeMotoristas() {
		assertEquals(1, cf.totalDeMotoristas());
	}
	
	@Test
	void testTotalDeCobradores() {
		assertEquals(0, cf.totalDeCobradores());
	}

}
