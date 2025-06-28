package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class DepartementServiceImplTest {

    @Autowired
    private DepartementRepository departementRepository;

    @Test
    public void testAddDepartement() {
        Departement departement = new Departement("Informatique");
        Departement saved = departementRepository.save(departement);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Informatique");
    }
}
