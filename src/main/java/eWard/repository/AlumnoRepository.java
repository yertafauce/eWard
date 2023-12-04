package eWard.repository;


import java.util.List;
import java.util.Optional;

import eWard.entity.Alumno;
import eWard.entity.Curso;
import eWard.entity.Rol;
import eWard.entity.Usuario;

public interface AlumnoRepository<T> {
	
	List<Alumno> findAll();
	
	Alumno findByDni(Long dni);
	
	Alumno findByUsuario(Usuario usuario);
	
	Optional<Alumno> findByNombreAndApellidos(String nombre, String apellidos);
	
	List<Alumno> findByCurso(Curso curso);
	
	List<Alumno> findByRol(Rol rol);
	
	void deleteByDni(Long dni);
	
	Alumno saveOrUpdate(Alumno alumno);

}
