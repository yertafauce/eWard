package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Rol;

public interface RolCrudRepository extends CrudRepository<Rol, String>, RolRepository<Rol>{

}
