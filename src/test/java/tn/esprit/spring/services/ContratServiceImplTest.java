package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ContratServiceImplTest {

    @Autowired
    private ContratRepository contratRepository;

    private ContratServiceImpl contratService;

    @BeforeEach
    void setUp() {
        contratService = new ContratServiceImpl();
        contratService.contratRepository = contratRepository;
    }

    @Test
    public void testAddContrat() {
        Contrat contrat = new Contrat(new Date(), "CDI", 1500f);
        Contrat saved = contratService.addContrat(contrat);
        assertThat(saved.getReference()).isNotNull();
        assertThat(saved.getSalaire()).isEqualTo(1500f);
    }

    @Test
    public void testUpdateContrat() {
        Contrat contrat = contratService.addContrat(new Contrat(new Date(), "CDD", 1200f));
        contrat.setSalaire(1800f);
        Contrat updated = contratService.updateContrat(contrat);
        assertThat(updated.getSalaire()).isEqualTo(1800f);
    }

    @Test
    public void testRetrieveContrat() {
        Contrat contrat = contratService.addContrat(new Contrat(new Date(), "Stage", 800f));
        Contrat found = contratService.retrieveContrat(String.valueOf(contrat.getReference()));
        assertThat(found).isNotNull();
        assertThat(found.getTypeContrat()).isEqualTo("Stage");
    }

    @Test
    public void testDeleteContrat() {
        Contrat contrat = contratService.addContrat(new Contrat(new Date(), "CDI", 2000f));
        contratService.deleteContrat(String.valueOf(contrat.getReference()));
        assertThat(contratService.retrieveContrat(String.valueOf(contrat.getReference()))).isNull();
    }
    @Test
    public void testSettersAndGetters() {
        Contrat c = new Contrat();
        Date now = new Date();

        c.setReference(1L);
        c.setDateDebut(now);
        c.setTypeContrat("CDI");
        c.setSalaire(3000f);

        assertThat(c.getReference()).isEqualTo(1L);
        assertThat(c.getDateDebut()).isEqualTo(now);
        assertThat(c.getTypeContrat()).isEqualTo("CDI");
        assertThat(c.getSalaire()).isEqualTo(3000f);
    }

    @Test
    public void testConstructor() {
        Contrat c = new Contrat(new Date(), "CDD", 2500f);
        assertThat(c.getTypeContrat()).isEqualTo("CDD");
        assertThat(c.getSalaire()).isEqualTo(2500f);
    }
}
