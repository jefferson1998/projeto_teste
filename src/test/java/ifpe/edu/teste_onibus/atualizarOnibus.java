package ifpe.edu.teste_onibus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.controller.ControllerOnibusSMBG;
import ifpe.edu.smbg.model.entity.Onibus;

class atualizarOnibus {
	static Onibus onibus = new Onibus();
	static Onibus onibusAntigo = new Onibus();
	static ControllerOnibusSMBG controlerOnibus = new ControllerOnibusSMBG();
	
	@BeforeAll
	static void testCriarOnibus() {
		onibus.setTipo("Micro");
		onibus.setPlaca("KJD1029");
		onibus.setNumeroDePortas(2);
		onibus.setNumeroDeEixos(10);
		onibus.setModelo("FIAT");
		onibus.setFreioABS(true);
		onibus.setDirecaoHidraulica(true);
		onibus.setDirecaoEletrica(true);
		onibus.setCombustivel(10.5);
		onibus.setCodigoRenavam("12345");
		onibus.setChassi("187KD");
		onibus.setCapacidade(40);
		onibus.setCambioAutomatico(true);
		onibus.setArCondicionado(true);
		onibus.setAno(2017);
		onibus.setMarca("BOM");
		controlerOnibus.setOnibus(onibus);
		controlerOnibus.cadastrarOnibus();
	}

	@Test
	void testAtualizarCampos() {
		onibusAntigo = controlerOnibus.buscarOnibusPelaPlaca("KJD1029");
		controlerOnibus.getOnibus().setTipo("Macro");
		controlerOnibus.getOnibus().setPlaca("KJD1020");
		controlerOnibus.getOnibus().setNumeroDePortas(5);
		controlerOnibus.getOnibus().setNumeroDeEixos(20);
		controlerOnibus.getOnibus().setModelo("TAIF");
		controlerOnibus.getOnibus().setFreioABS(false);
		controlerOnibus.getOnibus().setDirecaoHidraulica(false);
		controlerOnibus.getOnibus().setDirecaoEletrica(false);
		controlerOnibus.getOnibus().setCombustivel(10);
		controlerOnibus.getOnibus().setCodigoRenavam("54321");
		controlerOnibus.getOnibus().setChassi("KD187");
		controlerOnibus.getOnibus().setCapacidade(04);
		controlerOnibus.getOnibus().setCambioAutomatico(false);
		controlerOnibus.getOnibus().setArCondicionado(false);
		controlerOnibus.getOnibus().setAno(2015);
		controlerOnibus.getOnibus().setMarca("ÒTIMO");
		controlerOnibus.alterarOnibus();

		assertNotNull(controlerOnibus.buscarOnibusPelaPlaca("KJD1020"));
		assertNotEquals("KJD1029", controlerOnibus.buscarOnibusPelaPlaca("KJD1020").getPlaca());
		assertEquals("KJD1020", controlerOnibus.buscarOnibusPelaPlaca("KJD1020").getPlaca());

	}
	
	@Test
	void limparTest() {
		for(int i = 0; i < controlerOnibus.listaTodos().size(); i++ ) {
			controlerOnibus.setOnibus(controlerOnibus.listaTodos().get(i));
			controlerOnibus.removerOnibus();
		}
	}

}
