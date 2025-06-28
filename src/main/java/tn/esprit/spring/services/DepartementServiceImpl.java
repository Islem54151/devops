package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

import java.util.List;

@Service
public class DepartementServiceImpl implements IDepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(String id) {
        departementRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Departement retrieveDepartement(String id) {
        return departementRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
