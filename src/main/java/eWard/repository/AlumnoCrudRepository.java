package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Alumno;

public interface AlumnoCrudRepository extends CrudRepository<Alumno, String>, AlumnoRepository<Alumno>{

}
