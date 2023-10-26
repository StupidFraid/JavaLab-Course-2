package ru.alexey4he.Lab_6.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alexey4he.Lab_6.entity.Discipline;
import ru.alexey4he.Lab_6.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDiscipline(){
        Query query = entityManager.createQuery("from Discipline ");
        List allDiscipline = query.getResultList();
        log.info("getAllDiscipline " + allDiscipline);
        return allDiscipline;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline){
        log.info("Update discipline "  + discipline.toString());
        return entityManager.merge(discipline);
    }

    @Override
    public Discipline getDiscipline(long id){
        log.info("Return discipline from ID: " + id);
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public int deleteDiscipline(long id){
        Query query = entityManager.createQuery("delete from Discipline "
        + "where id=:disciplineId");
        query.setParameter("disciplineId", id);
        return query.executeUpdate();
    }


}


//package ru.alexey4he.Lab_6.dao;
//
//        import lombok.extern.slf4j.Slf4j;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Repository;
//        import ru.alexey4he.Lab_6.entity.Student;
//
//        import javax.persistence.EntityManager;
//        import javax.persistence.Query;
//        import java.util.List;

//@Slf4j
//@Repository
//public class StudentDAOImpl implements StudentDAO {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Override
//    public List<Student> getAllStudent(){
//        Query query = entityManager.createQuery("from Student ");
//        List allStudents = query.getResultList();
//        log.info("getAllStudents " + allStudents);
//        return allStudents;
//
//    }
//
//    @Override
//    public Student saveStudent(Student student){
//        log.info("Update students "  + student.toString());
//        return entityManager.merge(student);
//    }
//
//    @Override
//    public Student getStudent(long id){
//        log.info("Return students from ID: " + id);
//        return entityManager.find(Student.class, id);
//    }
//
//    @Override
//    public int deleteStudent(long id){
//        Query query = entityManager.createQuery("delete from Student "
//                + "where id =:studentId");
//        query.setParameter("studentId", id);
//        return query.executeUpdate();
//    }
//}

