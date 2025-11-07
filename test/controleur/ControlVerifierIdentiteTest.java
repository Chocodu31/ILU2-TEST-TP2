package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	@DisplayName("Villageois existe")
	void testVerifierIdentiteExistant() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
	}
	
	@Test
	@DisplayName("Villageois n'existe pas")
	void testVerifierIdentitenonExistant() {
		assertFalse(controlVerifierIdentite.verifierIdentite("Panoramix"));
	}

}
