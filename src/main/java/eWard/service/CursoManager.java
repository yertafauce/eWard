package eWard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eWard.entity.Curso;
import eWard.entity.Profesor;
import eWard.repository.CursoRepository;

@Transactional
@Component("cursoMag")
public class CursoManager {
	
	@Autowired
	private CursoRepository<?> cursoRepository;
	
	public List<Curso> getAll() {
		
		return cursoRepository.findAll();
		
	}
	
	public Curso getById(Long id) {
		
		return cursoRepository.findById(id);
		
	}
	
	public Optional<Curso> getByNombre(String nombre) {
		
		return cursoRepository.findByNombre(nombre);
		
	}
	
	public Optional<Curso> getByIdTutor(Profesor tutor) {
		
		return cursoRepository.findByIdTutor(tutor.getDni());
		
	}
	
	public void delete(Curso curso) {
		
		cursoRepository.deleteById(curso.getId());
		
	}
	
	public Curso saveOrUpdate(Curso curs) {
		
		Curso curso = cursoRepository.saveOrUpdate(curs);
		return curso;
		
	}

}
