package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		Gaulois obelix = new Gaulois("Obelix", 100);
		village.ajouterHabitant(obelix);
		Gaulois asterix = new Gaulois("Asterix", 20);
		village.ajouterHabitant(asterix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] expected = new String[3];
		expected[0] = "Abraracourcix";
		expected[1] = "Obelix";
		expected[2] = "Asterix";
		String[] whatwegot = controlAfficherVillage.donnerNomsVillageois();
		for (int i = 0; i<3; i++) {
			assertEquals(expected[i],whatwegot[i]);
		}
		
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	@DisplayName("Il y a 5 etal")
	void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}
