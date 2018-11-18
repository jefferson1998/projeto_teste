package ifpe.edu.teste_onibus;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ifpe.edu.smbg.controller.ControllerOnibusSMBG;
import ifpe.edu.smbg.model.entity.Onibus;

class buscarOnibus {

	static Onibus onibus = new Onibus();
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
	void testBuscarPeloChassis() {
		assertNotNull(controlerOnibus.buscarOnibusPeloChassi("187KD"));
		assertNull(controlerOnibus.buscarOnibusPeloChassi("187KD23"));
		assertEquals("187KD", controlerOnibus.buscarOnibusPeloChassi("187KD").getChassi());
		assertNotEquals("13487KD", controlerOnibus.buscarOnibusPeloChassi("187KD").getChassi());
	}
	
	@Test
	void testBuscarPeloCodigoRenavam() {
		assertNotNull(controlerOnibus.buscarOnibusPeloCodigoRenavam("12345"));
		assertNull(controlerOnibus.buscarOnibusPeloCodigoRenavam("1234532"));
		assertNotEquals("1234235", controlerOnibus.buscarOnibusPeloCodigoRenavam("12345").getCodigoRenavam());
		assertEquals("12345", controlerOnibus.buscarOnibusPeloCodigoRenavam("12345").getCodigoRenavam());
	}	
	
	@Test
	void testLimpar() {
		try {
			assertNotNull(controlerOnibus.buscarOnibusPeloCodigoRenavam("12345"));
			controlerOnibus.setOnibus(controlerOnibus.buscarOnibusPeloCodigoRenavam("12345"));
			controlerOnibus.removerOnibus();
			assertNull(controlerOnibus.buscarOnibusPeloCodigoRenavam("12345"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
