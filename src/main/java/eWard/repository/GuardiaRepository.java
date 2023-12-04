package eWard.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import eWard.entity.Guardia;

public interface GuardiaRepository<T> {
	
	List<Guardia> findAll();
	
	Guardia findById(Long id);
	
	Optional<Guardia> findByHora(Date hora);
	
	List<Guardia> findByDniProfesor(Long idProfesor);
	
	List<Guardia> findByIdCurso(Long idCurso);
	
	List<Guardia> findByIdAusencia(Long idAusencia);

	void deleteById(Long id);
	
	Guardia saveOrUpdate(Guardia guardia);
}
