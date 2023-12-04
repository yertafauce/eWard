package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Profesor;

public interface ProfesorCrudRepository extends CrudRepository<Profesor, String>, ProfesorRepository<Profesor>{

}
