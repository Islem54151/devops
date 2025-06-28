package tn.esprit.spring.services;

import tn.esprit.spring.entities.Departement;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class DepartementServiceImplMock implements IDepartementService {

    private final Map<Long, Departement> store = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<Departement> retrieveAllDepartements() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Departement addDepartement(Departement d) {
        long id = idCounter.getAndIncrement();
        d.setId(id);
        store.put(id, d);
        return d;
    }

    @Override
    public Departement updateDepartement(Departement d) {
        if (d.getId() == null || !store.containsKey(d.getId())) {
            throw new NoSuchElementException("Departement not found");
        }
        store.put(d.getId(), d);
        return d;
    }

    @Override
    public void deleteDepartement(String id) {
        store.remove(Long.parseLong(id));
    }

    @Override
    public Departement retrieveDepartement(String id) {
        return store.get(Long.parseLong(id));
    }
}
