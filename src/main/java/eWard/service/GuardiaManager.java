package eWard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eWard.entity.Ausencia;
import eWard.entity.Curso;
import eWard.entity.Guardia;
import eWard.entity.Profesor;
import eWard.repository.GuardiaRepository;

@Transactional
@Component("guardiaMag")
public class GuardiaManager {
	
	@Autowired
	private GuardiaRepository<?> guardiaRepository;
	
	public List<Guardia> getAll() {
		
		return (List<Guardia>) guardiaRepository.findAll();
		
	}
	
	public Guardia getById(Long id) {
		
		return (Guardia) guardiaRepository.findById(id);
		
	}
	
	public Optional<Guardia> getByHora(Date hora) {
		
		return (Optional<Guardia>) guardiaRepository.findByHora(hora);
		
	}
	
	public List<Guardia> getByIdProfesor(Profesor profesor) {
		
		return (List<Guardia>) guardiaRepository.findByDniProfesor(profesor.getDni());
		
	}
	
	public List<Guardia> getByIdAusencia(Ausencia ausencia) {
		
		return (List<Guardia>) guardiaRepository.findByIdAusencia(ausencia.getId());
		
	}
	
	public List<Guardia> getByIdCurso(Curso curso) {
		
		return (List<Guardia>) guardiaRepository.findByIdCurso(curso.getId());
		
	}
	
	public void delete(Guardia guardia) {
		
		guardiaRepository.deleteById(guardia.getId());
		
	}
	
	public Guardia saveOrUpdate(Guardia guard) {
		
		Guardia guardia = guardiaRepository.saveOrUpdate(guard);
		return guardia;
		
	}

}
