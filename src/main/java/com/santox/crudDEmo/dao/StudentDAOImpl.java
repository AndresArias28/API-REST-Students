package com.santox.crudDEmo.dao;

import com.santox.crudDEmo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//proporciona escaneo de componentes, traduce excepciones JDBC
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private final EntityManager entityManager;

    //inject entity manager constructor
    @Autowired//permite inyeccion de dependencias
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //crear sentencia personalizada JPQL
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName", Student.class);//seleccionar la tabla estudiante y ordenarla por apellido
        return query.getResultList();
    }

  /*  @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);//seleccionar estudiante por apellido
        query.setParameter("data", lastName);
        return query.getResultList();
    }*/

    @Override
    @Transactional//personalizando una actualizacion. en caso de presentar una excepción, con esta anoctacion se garantiza que cualquier cambio en la BD se revierta automaticamente
    public String updateStudent(int id, Student student) {
        Student updateStudent = entityManager.find(Student.class, id);
        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setLastName(student.getLastName());
        entityManager.merge(updateStudent);
        return "Student successfully updated";
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        //recuperar el estudiante a remover
        Student student = entityManager.find(Student.class, id);
        //eliminar el estudiante
        entityManager.remove(student);
    }

/*    @Override
    @Transactional
    public int deleteAllStudent() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }*/

}
