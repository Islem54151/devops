package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class EntrepriseServiceImplTest {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Test
    public void testAddEntreprise() {
        Entreprise entreprise = new Entreprise("OpenAI", "Recherche");
        Entreprise saved = entrepriseRepository.save(entreprise);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("OpenAI");
    }
}
