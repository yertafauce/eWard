package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Ausencia;

public interface AusenciaCrudRepository extends CrudRepository<Ausencia, String>, AusenciaRepository<Ausencia>{

}
