package eWard.repository;

import java.util.List;
import java.util.Optional;

import eWard.entity.Profesor;

public interface ProfesorRepository<T> {

	public List<Profesor> findAll();
	
	public Profesor findByDni(Long dni);
	
	public Profesor findByIdUsuario(Long id);
	
	public Optional<Profesor> findByNombreAndApellidos(String nombre, String apellidos);
	
	public List<Profesor> findByIdRol(Long idRol);
	
	public void deleteByDni(Long id);
	
	public Profesor saveOrUpdate(Profesor profesor);
	
}
