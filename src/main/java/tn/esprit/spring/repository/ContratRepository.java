package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
