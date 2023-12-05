package eWard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eWard.entity.Ausencia;
import eWard.entity.Curso;
import eWard.entity.Usuario;
import eWard.repository.AusenciaRepository;

@Transactional
@Component("ausenciaMag")
public class AusenciaManager {
	
	@Autowired
	private AusenciaRepository<?> ausenciaRepository;
	
	public List<Ausencia> getAll() {
		
		return (List<Ausencia>) ausenciaRepository.findAll();
		
	}
	
	public Ausencia getById(Long id) {
		
		return (Ausencia) ausenciaRepository.findById(id);
		
	}
	
	public Optional<Ausencia> getByFecha(Date date) {
		
		return (Optional<Ausencia>) ausenciaRepository.findByFecha(date);
		
	}
	
	public List<Ausencia> getByJustificada(boolean justificada) {
		
		return (List<Ausencia>) ausenciaRepository.findByJustificada(justificada);
		
	}
	
	public List<Ausencia> getByCurso(Curso curso) {
		
		return (List<Ausencia>) ausenciaRepository.findByCurso(curso.getId());
		
	}
	
	public List<Ausencia> getByUsuario(Usuario usuario) {
		
		return (List<Ausencia>) ausenciaRepository.findByUsuario(usuario.getId());
		
	}

	public void delete(Ausencia ausencia) {
		
		ausenciaRepository.deleteById(ausencia.getId());
		
	}
	
	public Ausencia saveOrUpdate(Ausencia ausenc) {
		
		Ausencia ausencia = ausenciaRepository.saveOrUpdate(ausenc);
		return ausencia;
		
	}
}
