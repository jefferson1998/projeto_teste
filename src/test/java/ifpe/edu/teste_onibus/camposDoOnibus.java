package ifpe.edu.teste_onibus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ifpe.edu.smbg.model.entity.Onibus;

class camposDoOnibus {

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
	}
	
	@Test
	void testCamposEquals() {
		assertEquals("Micro", onibus.getTipo());
		assertEquals("KJD1029", onibus.getPlaca());
		assertEquals(2,onibus.getNumeroDePortas());
		assertEquals(10, onibus.getNumeroDeEixos());
		assertEquals("FIAT", onibus.getModelo());
		assertEquals(10.5, onibus.getCombustivel());
		assertEquals("12345",onibus.getCodigoRenavam());
		assertEquals("187KD", onibus.getChassi());
		assertEquals(40, onibus.getCapacidade());
		assertEquals(2017, onibus.getAno());
		assertEquals("BOM",onibus.getMarca());
	}
	
	@Test
	void testCamposNotEquals() {
		assertNotEquals("Macro", onibus.getTipo());
		assertNotEquals("KJD10229", onibus.getPlaca());
		assertNotEquals(22,onibus.getNumeroDePortas());
		assertNotEquals(102, onibus.getNumeroDeEixos());
		assertNotEquals("ATFI", onibus.getModelo());
		assertNotEquals(22, onibus.getCombustivel());
		assertNotEquals("54321",onibus.getCodigoRenavam());
		assertNotEquals("18a7KD", onibus.getChassi());
		assertNotEquals(420, onibus.getCapacidade());
		assertNotEquals(2018, onibus.getAno());
		assertNotEquals("RUIM",onibus.getMarca());
	}
	
	@Test
	void testCamposTrue() {
		assertTrue(onibus.isFreioABS());
		assertTrue(onibus.isDirecaoHidraulica());
		assertTrue(onibus.isDirecaoEletrica());
		assertTrue(onibus.isCambioAutomatico());
		assertTrue(onibus.isArCondicionado());
	}
	
	@Test
	void testCamposFalse() {
		onibus.setArCondicionado(false);
		onibus.setFreioABS(false);
		onibus.setDirecaoEletrica(false);
		onibus.setDirecaoHidraulica(false);
		onibus.setCambioAutomatico(false);
		assertFalse(onibus.isFreioABS());
		assertFalse(onibus.isDirecaoHidraulica());
		assertFalse(onibus.isDirecaoEletrica());
		assertFalse(onibus.isCambioAutomatico());
		assertFalse(onibus.isArCondicionado());
	}
	
	@Test
	void testOnibusSame() {
		Onibus o = new Onibus();
		assertNotSame(o, onibus);
		o = onibus;
		assertSame(o,onibus);
	}
	
}
