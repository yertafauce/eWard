package eWard.repository;

import java.util.List;
import java.util.Optional;

import eWard.entity.Curso;

public interface CursoRepository<T> {
	
	List<Curso> findAll();
	
	Curso findById(Long id);
	
	Optional<Curso> findByNombre(String nombre);
	
	Optional<Curso> findByIdTutor(Long idTutor);
	
	void deleteById(Long id);
	
	Curso saveOrUpdate(Curso curso);
	
}
