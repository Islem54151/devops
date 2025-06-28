package tn.esprit.spring.services;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

import java.util.List;

public class EmployeServiceImpl implements IEmployeService {

    private EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public List<Employe> RetrieveAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public Employe addEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public void deleteEmploye(String id) {
        employeRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public Employe RetrieveEmploye(String id) {
        return employeRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
