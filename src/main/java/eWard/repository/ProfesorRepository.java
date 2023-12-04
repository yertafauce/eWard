package eWard.repository;

import java.util.List;
import java.util.Optional;

import eWard.entity.Profesor;

public interface ProfesorRepository<T> {

	public List<Profesor> findAll();
	
	public Profesor findByDni(Long id);
	
	public Optional<Profesor> findByNombreAndApellidos(String nombre, String apellidos);
	
	public
	
}
