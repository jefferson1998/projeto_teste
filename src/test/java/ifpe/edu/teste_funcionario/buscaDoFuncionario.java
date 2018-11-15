package ifpe.edu.teste_funcionario;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.controller.ControllerFuncionarioSMBG;
import ifpe.edu.smbg.model.entity.Admissao;
import ifpe.edu.smbg.model.entity.Conta;
import ifpe.edu.smbg.model.entity.Endereco;
import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.Identidade;

class buscaDoFuncionario {
	static Funcionario f = new Funcionario();
	private final ControllerFuncionarioSMBG cf = new ControllerFuncionarioSMBG();

	@BeforeAll
	public static void criandoFuncionario() {
		
		Conta c = new Conta();
        Identidade i = new Identidade();
        Endereco e = new Endereco("SP", 0, "Magano", "123");
        Admissao ad = new Admissao();

        c.setNumeroAgencia("12");
        c.setNumeroConta("15");
        ad.setDataAdmissao("15/05/1998");
        ad.setFuncao("Motorista");
        ad.setHoras(12);
        ad.setInstrucao("Zé");
        ad.setNumeroDeFilhos(12);
        ad.setValorSalario(1200);
        ad.setConta(c);
        f.setCpf("125.225.945/00");
        i.setNome("José");
        i.setNumeroIdentidade("17");
        i.setNomeDaMae("Maria");
        i.setOrgaoEmissor("SDS");
        i.setDataDeEmissao("12/05/1998");
        i.setUFIdentidade("PE");
        f.setFuncionarioIdentidade(i);
        f.setFuncionarioEndereco(e);
        f.setAdmissao(ad);
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
			Funcionario fu = cf.buscarFuncionarioPeloCPF("125.225.945/00");
			assertNotNull(fu);
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
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTotalDeMotoristas() {
		assertEquals(6, cf.totalDeMotoristas());
	}
	
	@Test
	void testTotalDeCobradores() {
		assertEquals(0, cf.totalDeCobradores());
	}

}
