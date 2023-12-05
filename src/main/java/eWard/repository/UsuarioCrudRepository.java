package eWard.repository;

import org.springframework.data.repository.CrudRepository;

import eWard.entity.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, String>, UsuarioRepository<Usuario>{

}
