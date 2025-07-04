package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    // Pas besoin d'ajouter deleteAllById, déjà présent dans JpaRepository
}
