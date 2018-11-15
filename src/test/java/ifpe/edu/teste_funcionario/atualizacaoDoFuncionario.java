package ifpe.edu.teste_funcionario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import ifpe.edu.smbg.controller.ControllerFuncionarioSMBG;
import ifpe.edu.smbg.model.entity.Admissao;
import ifpe.edu.smbg.model.entity.Conta;
import ifpe.edu.smbg.model.entity.Endereco;
import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.Identidade;

class atualizacaoDoFuncionario {

	static Funcionario f = new Funcionario();
	private static ControllerFuncionarioSMBG cf = new ControllerFuncionarioSMBG();

	@BeforeAll
	public static void criandoFuncionario() {
		f = cf.buscarFuncionarioPeloCPF("125.225.945/10");
	}
	
	@BeforeEach
	void testMostandoFuncionarioAntigo() {
		System.out.println(f.getAdmissao().getFuncao());
	}
	
	@Test()
	void testAtualizandoFuncionarioCPF() {
		Funcionario funcionarioAntigo = new Funcionario();
		funcionarioAntigo = f;
		f.getAdmissao().setFuncao("Cobrador");
		cf.setFuncionario(f);
		cf.alterarFuncionario();
//	    assertThrows(Exception.class, () -> {
//	    	cf.alterarFuncionario();
//	    });
		assertNotEquals(funcionarioAntigo.getAdmissao().getFuncao(), f.getAdmissao().getFuncao());
	}

	
}
