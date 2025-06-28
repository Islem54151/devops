package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeServiceImplTest {

    @Autowired
    private EmployeRepository employeRepository;

    @Test
    public void testSaveEmploye() {
        Employe employe = new Employe();
        employe.setPrenom("Islem");
        employe.setNom("Nasraoui");
        employe.setEmail("islem@example.com");
        employe.setPassword("password123");
        employe.setActif(true);
        employe.setRole(Role.ADMINISTRATEUR);

        Employe savedEmploye = employeRepository.save(employe);

        assertThat(savedEmploye.getId()).isNotNull();
    }
}
