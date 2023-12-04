package eWard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eWard.entity.Profesor;
import eWard.entity.Rol;
import eWard.entity.Usuario;
import eWard.repository.ProfesorRepository;

@Transactional
@Component("profesorMag")
public class ProfesorManager {
	
	@Autowired
	private ProfesorRepository<?> profesorRepository;
	
	public List<Profesor> getAll() {
		
		return (List<Profesor>) profesorRepository.findAll();
		
	}
	
	public Profesor getByDni(Long dni) {
		
		return (Profesor) profesorRepository.findByDni(dni);
		
	}
	
	public Profesor getByUsuario(Usuario usuario) {
		
		return (Profesor) profesorRepository.findByIdUsuario(usuario.getId());
		
	}
	
	public Optional<Profesor> getByNombreAndApellidos(String nombre, String apellidos) {
		
		return (Optional<Profesor>) profesorRepository.findByNombreAndApellidos(nombre, apellidos);
		
	}
	
	public List<Profesor> getByRol(Rol rol) {
		
		return (List<Profesor>) profesorRepository.findByIdRol(rol.getId());
		
	}
	
	public void delete(Profesor profesor) {
		
		profesorRepository.deleteByDni(profesor.getDni());
		
	}
 }
