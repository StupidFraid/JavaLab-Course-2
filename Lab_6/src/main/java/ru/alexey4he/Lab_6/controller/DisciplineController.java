package ru.alexey4he.Lab_6.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexey4he.Lab_6.entity.Discipline;
import ru.alexey4he.Lab_6.model.DisciplineResponse;
import ru.alexey4he.Lab_6.model.StatusCode;
import ru.alexey4he.Lab_6.model.TypeOperations;
import ru.alexey4he.Lab_6.service.DisciplineService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public List<Discipline> showAllDiscipline(){
        List<Discipline> allDisciplines = disciplineService.getAllDiscipline();
        return allDisciplines;
    }

    @GetMapping("/disciplines/{id}")
    public DisciplineResponse getDiscipline(@PathVariable("id") long id){

        Discipline findDiscipline = disciplineService.getDiscipline(id);

        if (findDiscipline != null){
            return new DisciplineResponse(TypeOperations.FIND, findDiscipline, StatusCode.OK);
        }
        else {
            return new DisciplineResponse (TypeOperations.FIND, null, StatusCode.ERROR);
        }
    }

    @PostMapping("/disciplines")
    public DisciplineResponse saveDiscipline(@RequestBody Discipline discipline){
        DisciplineResponse response = new DisciplineResponse(
                TypeOperations.ADD, disciplineService.saveDiscipline(discipline), StatusCode.OK
        );
        return response;
    }


    @PutMapping("/disciplines")
    public DisciplineResponse updateDisciplines(@RequestBody Discipline discipline){
        Discipline existingDisciplines = disciplineService.getDiscipline(discipline.getId());
        DisciplineResponse response;
        if (existingDisciplines != null){
            response = new DisciplineResponse(
                    TypeOperations.UPDATE, disciplineService.saveDiscipline(discipline), StatusCode.OK);
        }
        else {
            response = new DisciplineResponse(
                    TypeOperations.UPDATE, null, StatusCode.ERROR);
        }
        return response;
    }

    @DeleteMapping("/disciplines/{id}")
    public DisciplineResponse updateDisciplines(@PathVariable("id") long id){
        Discipline deleteDisciplineObject = disciplineService.getDiscipline(id);
        int stateDeleteDiscipline = disciplineService.deleteDiscipline(id);
        if (stateDeleteDiscipline > 0){
            return new DisciplineResponse(TypeOperations.DELETE, deleteDisciplineObject, StatusCode.OK);
        }
        else {
            return new DisciplineResponse(TypeOperations.DELETE, deleteDisciplineObject, StatusCode.ERROR);
        }
    }

}
