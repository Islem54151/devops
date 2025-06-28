package tn.esprit.spring.services;

import tn.esprit.spring.entities.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    void deleteContrat(String id);
    Contrat retrieveContrat(String id);
}
