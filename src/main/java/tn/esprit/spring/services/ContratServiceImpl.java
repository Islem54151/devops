package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

import java.util.List;

@Service
public class ContratServiceImpl implements IContratService {

    @Autowired
    ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(String id) {
        contratRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Contrat retrieveContrat(String id) {
        return contratRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
