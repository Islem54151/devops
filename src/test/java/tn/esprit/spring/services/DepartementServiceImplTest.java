package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class DepartementServiceImplTest {

    @Autowired
    private DepartementRepository departementRepository;

    private DepartementServiceImpl departementService;

    @BeforeEach
    public void setUp() {
        departementService = new DepartementServiceImpl();
        departementService.departementRepository = departementRepository;
    }

    @Test
    public void testAddDepartement() {
        Departement d = new Departement("Finance");
        Departement saved = departementService.addDepartement(d);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Finance");
    }

    @Test
    public void testRetrieveAllDepartements() {
        departementService.addDepartement(new Departement("RH"));
        departementService.addDepartement(new Departement("IT"));
        assertThat(departementService.retrieveAllDepartements()).hasSizeGreaterThanOrEqualTo(2);
    }

    @Test
    public void testUpdateDepartement() {
        Departement d = departementService.addDepartement(new Departement("Logistique"));
        d.setName("Transport");
        Departement updated = departementService.updateDepartement(d);
        assertThat(updated.getName()).isEqualTo("Transport");
    }

    @Test
    public void testRetrieveDepartement() {
        Departement d = departementService.addDepartement(new Departement("Audit"));
        Departement found = departementService.retrieveDepartement(String.valueOf(d.getId()));
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Audit");
    }

    @Test
    public void testDeleteDepartement() {
        Departement d = departementService.addDepartement(new Departement("Juridique"));
        departementService.deleteDepartement(String.valueOf(d.getId()));
        Optional<Departement> deleted = departementRepository.findById(d.getId());
        assertThat(deleted).isEmpty();
    }
}
