package eWard.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import eWard.entity.Ausencia;

public interface AusenciaRepository<T> {
	
	List<Ausencia> findAll();
	
	Ausencia findById(Long id);
	
	Optional<Ausencia> findByFecha(Date date);
	
	List<Ausencia> findByJustificada(boolean justificada);
	
	List<Ausencia> findByCurso(Long id);
	
	List<Ausencia> findByUsuario(Long id);
	
	void deleteById(Long id);
	
	Ausencia saveOrUpdate(Ausencia ausencia);

}
