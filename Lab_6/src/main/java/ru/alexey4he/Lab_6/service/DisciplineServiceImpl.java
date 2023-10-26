package ru.alexey4he.Lab_6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexey4he.Lab_6.dao.DisciplineDAO;
import ru.alexey4he.Lab_6.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDiscipline(){
        return disciplineDAO.getAllDiscipline();
    }

    @Override
    @Transactional
    public Discipline getDiscipline(long id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public int deleteDiscipline(Long id) {
        return disciplineDAO.deleteDiscipline(id);
    }

}
