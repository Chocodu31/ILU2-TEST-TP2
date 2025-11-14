package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
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
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}

	@Test
	@DisplayName("Vendeur trouvé")
	void testTrouverEtalVendeur() {
		assertEquals(etal,controlTrouverEtalVendeur.trouverEtalVendeur("Obelix"));
	}
	
	@Test
	@DisplayName("Vendeur non trouvé")
	void testNonTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Abraracourcix"));
	}

}
