package tn.esprit.spring.services;

import tn.esprit.spring.entities.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    void deleteDepartement(String id);
    Departement retrieveDepartement(String id);
}
