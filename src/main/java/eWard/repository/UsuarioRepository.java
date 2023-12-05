package eWard.repository;

import java.util.List;

import eWard.entity.Usuario;

public interface UsuarioRepository<T> {
	
	List<Usuario> findAll();
	
	Usuario findById(Long id);
	
	List<Usuario> findByNombre(String nombre);
	
	List<Usuario> findByRol(Long idRol);
	
	List<Usuario> findByNombreAndRol(String nombre, Long idRol);
	
	void deleteById(Long id);
	
	Usuario saveOrUpdate(Usuario usuario);
}
