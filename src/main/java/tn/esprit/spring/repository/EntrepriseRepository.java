package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    // Tu peux ajouter des méthodes personnalisées si nécessaire
}
