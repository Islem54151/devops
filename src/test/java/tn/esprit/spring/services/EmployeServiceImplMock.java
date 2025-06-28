package tn.esprit.spring.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.entities.Employe;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class EmployeServiceImplMock implements IEmployeService {

    private final Map<Long, Employe> employeStore = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<Employe> RetrieveAllEmploye() {
        return new ArrayList<>(employeStore.values());
    }

    @Override
    public Employe addEmploye(Employe e) {
        long id = idGenerator.getAndIncrement();
        e.setId(id);
        employeStore.put(id, e);
        return e;
    }

    @Override
    public void deleteEmploye(String id) {
        employeStore.remove(Long.parseLong(id));
    }

    @Override
    public Employe updateEmploye(Employe e) {
        Long id = e.getId();
        if (id == null || !employeStore.containsKey(id)) {
            throw new NoSuchElementException("Employe with id " + id + " not found.");
        }
        employeStore.put(id, e);
        return e;
    }

    @Override
    public Employe RetrieveEmploye(String id) {
        return employeStore.get(Long.parseLong(id));
    }
}
