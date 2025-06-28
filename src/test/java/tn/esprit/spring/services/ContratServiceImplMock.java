package tn.esprit.spring.services;

import tn.esprit.spring.entities.Contrat;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ContratServiceImplMock implements IContratService {

    private final Map<Long, Contrat> contratStore = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public List<Contrat> retrieveAllContrats() {
        return new ArrayList<>(contratStore.values());
    }

    @Override
    public Contrat addContrat(Contrat c) {
        long id = idGen.getAndIncrement();
        c.setReference(id);
        contratStore.put(id, c);
        return c;
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        contratStore.put(c.getReference(), c);
        return c;
    }

    @Override
    public void deleteContrat(String id) {
        contratStore.remove(Long.parseLong(id));
    }

    @Override
    public Contrat retrieveContrat(String id) {
        return contratStore.get(Long.parseLong(id));
    }
}
