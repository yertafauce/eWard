package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Guardia;

public interface GuardiaCrudRepository extends CrudRepository<Guardia, String>, GuardiaRepository<Guardia> {

}
