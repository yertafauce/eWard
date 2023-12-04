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
	
	Alumno findByUsuario(Long idUsuario);
	
	Optional<Alumno> findByNombreAndApellidos(String nombre, String apellidos);
	
	List<Alumno> findByCurso(Long idCurso);
	
	List<Alumno> findByRol(Long idRol);
	
	void deleteByDni(Long dni);
	
	Alumno saveOrUpdate(Alumno alumno);

}
