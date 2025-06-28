package tn.esprit.spring.services;

import tn.esprit.spring.entities.Entreprise;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class EntrepriseServiceImplMock implements IEntrepriseService {

    private final Map<Long, Entreprise> store = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<Entreprise> retrieveAllEntreprises() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Entreprise addEntreprise(Entreprise entreprise) {
        long id = idCounter.getAndIncrement();
        entreprise.setId(id);
        store.put(id, entreprise);
        return entreprise;
    }

    @Override
    public Entreprise updateEntreprise(Entreprise entreprise) {
        if (entreprise.getId() == null || !store.containsKey(entreprise.getId())) {
            throw new NoSuchElementException("Entreprise not found");
        }
        store.put(entreprise.getId(), entreprise);
        return entreprise;
    }

    @Override
    public void deleteEntreprise(String id) {
        store.remove(Long.parseLong(id));
    }

    @Override
    public Entreprise retrieveEntreprise(String id) {
        return store.get(Long.parseLong(id));
    }
}
