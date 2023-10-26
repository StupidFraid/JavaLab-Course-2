package ru.alexey4he.Lab_6.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.Lab_6.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDiscipline();
    Discipline getDiscipline(long id);

    Discipline saveDiscipline(Discipline discipline);

    int deleteDiscipline(Long id);
}
