package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public List<Entreprise> retrieveAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise addEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public void deleteEntreprise(String id) {
        entrepriseRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Entreprise retrieveEntreprise(String id) {
        return entrepriseRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
