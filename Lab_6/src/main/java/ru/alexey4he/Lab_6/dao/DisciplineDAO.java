package ru.alexey4he.Lab_6.dao;

import org.springframework.stereotype.Repository;
import ru.alexey4he.Lab_6.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDAO {
    List<Discipline> getAllDiscipline();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(long id);

    int deleteDiscipline(long id);

}

