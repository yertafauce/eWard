package eWard.repository;


import java.util.List;
import java.util.Optional;

import eWard.entity.Alumno;

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
