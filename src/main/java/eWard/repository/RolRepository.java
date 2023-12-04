package eWard.repository;

import java.util.List;

import eWard.entity.Rol;

public interface RolRepository<T> {
	
	public List<Rol> findAll();
	
	public Rol findById(Long id);

}
