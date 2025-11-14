package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Etal etal;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		Gaulois obelix = new Gaulois("Obelix", 100);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "Mehnir", 10);
		etal = village.rechercherEtal(obelix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	@DisplayName("C'est un vendeur")
	void testIsVendeur() {
		assertTrue(controlLibererEtal.isVendeur("Obelix"));
	}
	
	@Test
	@DisplayName("C'est pas un vendeur")
	void testIsNotVendeur() {
		assertFalse(controlLibererEtal.isVendeur("Abraracourcix"));
	}

	@Test
	void testLibererEtal() {
		String[] expected = new String[5];
		expected[0] = "true";
		expected[1] = "Obelix";
		expected[2] = "Mehnir";
		expected[3] = "10";
		expected[4] = "0";
		String[] whatwegot = controlLibererEtal.libererEtal("Obelix");
		for (int i = 0; i<5; i++) {
			assertEquals(expected[i],whatwegot[i]);
		}	
	}
	
	@Test
	void testLibererEtalVide() {
		assertEquals(null,controlLibererEtal.libererEtal("kevin"));
	}
}
