package ifpe.edu.teste_funcionario;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.model.entity.Admissao;
import ifpe.edu.smbg.model.entity.Conta;
import ifpe.edu.smbg.model.entity.Endereco;
import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.Identidade;

class camposDoFuncionario {

	static Funcionario f = new Funcionario();
	
	@BeforeAll
	static void criandoFuncionario() {
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
        f.setCpf("125.225.945/10");
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
	void testCamposNaoNulos() {
		assertNotNull("CPF não nulo", f.getCpf());
		assertNotNull("RG" , f.getFuncionarioIdentidade());
		assertNotNull("Admissão " , f.getAdmissao());
		assertNotNull("Endereço" , f.getFuncionarioEndereco());
		assertNotNull("Título " , f.getFuncionarioTitulo().getSecaoTitulo());
		assertNotNull("Título " , f.getFuncionarioTitulo().getZonaTitulo());

	}
	
	@Test
	void testCamposNulo() {
		assertNull("Título " , f.getFuncionarioTitulo().getNumeroTitulo());
		assertNull("CNH" , f.getFuncionarioCNH().getNumeroCNH());
		assertNull("CNH" , f.getFuncionarioCNH().getCategoriaCNH());
		assertNull("CTPS" , f.getFuncionarioCTPS().getEstadoCTPS());
		assertNull("CTPS" , f.getFuncionarioCTPS().getNumeroCTPS());
		assertNull("CTPS" , f.getFuncionarioCTPS().getSerieCTPS());
		assertNull("Estado cívil" , f.getEstadoCivil());
		assertNull("E-mail", f.getEmailfuncionario());
		assertNull("Telefone" , f.getTelefonefuncionario());
	}

}
