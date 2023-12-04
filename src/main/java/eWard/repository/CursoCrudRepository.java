package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Curso;

public interface CursoCrudRepository extends CrudRepository<Curso, String>, CursoRepository<Curso> {

}
