package eWard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import eWard.entity.Alumno;
import eWard.entity.Curso;
import eWard.entity.Rol;
import eWard.entity.Usuario;
import eWard.repository.AlumnoRepository;

@Transactional
@Component("alumnoMag")
public class AlumnoManager {
	
	@Autowired
	private AlumnoRepository<?> alumnoRepository;
	
	public List<Alumno> getAll(){
		
		return (List<Alumno>) alumnoRepository.findAll();
		
	}
	
	public Alumno getByDni(Long dni) {
		
		return (Alumno) alumnoRepository.findByDni(dni);
		
	}
	
	public Optional<Alumno> getByNombreAndApellidos(String nombre, String apellidos) {
		
		return (Optional<Alumno>) alumnoRepository.findByNombreAndApellidos(nombre, apellidos);
		
	}
	
	public Alumno getByUsuario(Usuario usuario) {
		
		return alumnoRepository.findByUsuario(usuario.getId());
		
	}
	
	public List<Alumno> getByCurso(Curso curso) {
		
		return alumnoRepository.findByCurso(curso.getId());
		
	}
	
	public List<Alumno> getByRol(Rol rol) {
		
		return alumnoRepository.findByRol(rol.getId());
		
	}
	
	public void deleteByDni(Alumno alumno) {
		
		alumnoRepository.deleteByDni(alumno.getDni());
		
	}
	
	public Alumno saveOrUpdate(Alumno alumn) {
		
		Alumno alumno = alumnoRepository.saveOrUpdate(alumn);
		return alumno;
		
	}

}
