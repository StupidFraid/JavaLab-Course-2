package ru.alexey4he.Lab_6.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alexey4he.Lab_6.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudent(){
        Query query = entityManager.createQuery("from Student ");
        List allStudents = query.getResultList();
        log.info("getAllStudents " + allStudents);
        return allStudents;

    }

    @Override
    public Student saveStudent(Student student){
        log.info("Update students "  + student.toString());
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(long id){
        log.info("Return students from ID: " + id);
        return entityManager.find(Student.class, id);
    }

    @Override
    public int deleteStudent(long id){
        Query query = entityManager.createQuery("delete from Student "
        + "where id =:studentId");
        query.setParameter("studentId", id);
        return query.executeUpdate();
    }
}
