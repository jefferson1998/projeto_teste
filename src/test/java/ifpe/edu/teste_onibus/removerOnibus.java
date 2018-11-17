package ifpe.edu.teste_onibus;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.controller.ControllerOnibusSMBG;
import ifpe.edu.smbg.model.entity.Onibus;

class removerOnibus {

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
		
	}
	
	@Test
	void testRemoverOnibus() {
		controlerOnibus.setOnibus(onibus);
		controlerOnibus.cadastrarOnibus();
		try {
			assertNotNull(controlerOnibus.buscarOnibusPelaPlaca("KJD1029"));
			controlerOnibus.setOnibus(controlerOnibus.buscarOnibusPelaPlaca("KJD1029"));
			controlerOnibus.removerOnibus();
			assertNull(controlerOnibus.buscarOnibusPelaPlaca("KJD1029"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testRemoverTodosOnibus() {
		for(int i = 0; i < controlerOnibus.listaTodos().size(); i++ ) {
			controlerOnibus.setOnibus(controlerOnibus.listaTodos().get(i));
			controlerOnibus.removerOnibus();
		}
		assertEquals(0,controlerOnibus.listaTodos().size());
	}
	
}
