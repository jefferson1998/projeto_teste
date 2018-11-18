package ifpe.edu.teste_funcionario;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.controller.ControllerFuncionarioSMBG;
import ifpe.edu.smbg.model.entity.Admissao;
import ifpe.edu.smbg.model.entity.Conta;
import ifpe.edu.smbg.model.entity.Endereco;
import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.Identidade;

class tempoDeRetornoFuncionario {

	static 	Funcionario f = new Funcionario();
	static ControllerFuncionarioSMBG cf = new ControllerFuncionarioSMBG();
		
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
	        i.setNumeroIdentidade("13");
	        i.setNomeDaMae("Maria");
	        i.setOrgaoEmissor("SDS");
	        i.setDataDeEmissao("12/05/1998");
	        i.setUFIdentidade("PE");
	        f.setFuncionarioIdentidade(i);
	        f.setFuncionarioEndereco(e);
	        f.setAdmissao(ad);
	        cf.setFuncionario(f);
	        cf.cadastrarFuncionario();
		}
		
		@Test
		void testTimeoutPreemptively1() {	
				assertTimeoutPreemptively(ofSeconds(1), 
						() -> {
							cf.buscarFuncionarioPeloCPF("125.225.945/00");
							System.out.println("FOI");
						}
				);
		}
		
		@Test
		void testTimeoutPreemptively2() {	
				assertTimeoutPreemptively(ofSeconds(0,5), 
						() -> {
							cf.buscarFuncionarioPeloCPF("125.225.945/00");
							System.out.println(" NÃO FOI");
						}
				);
		}
		
		@Test
		void limparTest() {
			for(int i = 0; i < cf.listaTodos().size(); i++ ) {
				cf.setFuncionario(cf.listaTodos().get(i));
				cf.removerFuncionario();
			}
		}

}
