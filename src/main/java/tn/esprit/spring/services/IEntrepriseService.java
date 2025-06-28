package tn.esprit.spring.services;

import tn.esprit.spring.entities.Entreprise;

import java.util.List;

public interface IEntrepriseService {
    List<Entreprise> retrieveAllEntreprises();
    Entreprise addEntreprise(Entreprise entreprise);
    Entreprise updateEntreprise(Entreprise entreprise);
    void deleteEntreprise(String id);
    Entreprise retrieveEntreprise(String id);
}
