package ifpe.edu.teste_onibus;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ifpe.edu.smbg.controller.ControllerOnibusSMBG;
import ifpe.edu.smbg.model.entity.Onibus;

class tempoDeRetornoOnibus {
	static ControllerOnibusSMBG controlerOnibus = new ControllerOnibusSMBG();
	static Onibus onibus = new Onibus();
	
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
	void testTimeoutPreemptively1() {	
			assertTimeoutPreemptively(ofSeconds(1), 
					() -> {
						controlerOnibus.buscarOnibusPelaPlaca("KJD1029");
						System.out.println("FOI");
					}
			);
	}
	
	@Test
	void testTimeoutPreemptively2() {	
			assertTimeoutPreemptively(ofSeconds(0,5), 
					() -> {
						controlerOnibus.buscarOnibusPelaPlaca("KJD1029");
						System.out.println(" NÃO FOI");
					}
			);
	}
	
	@Test
	void limparTest() {
		for(int i = 0; i < controlerOnibus.listaTodos().size(); i++ ) {
			controlerOnibus.setOnibus(controlerOnibus.listaTodos().get(i));
			controlerOnibus.removerOnibus();
		}
	}

}
