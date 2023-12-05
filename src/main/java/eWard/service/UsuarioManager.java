package eWard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eWard.entity.Rol;
import eWard.entity.Usuario;
import eWard.repository.UsuarioRepository;

@Transactional
@Component("usuarioMag")
public class UsuarioManager {
	
	@Autowired
	private UsuarioRepository<?> usuarioRepository;
	
	public List<Usuario> getAll() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
	}
	
	public Usuario getById(Long id) {
		
		return (Usuario) usuarioRepository.findById(id);
		
	}

	public List<Usuario> getByNombre(String nombre) {
		
		return (List<Usuario>) usuarioRepository.findByNombre(nombre);
		
	}
	
	public List<Usuario> getByRol(Rol rol) {
		
		return (List<Usuario>) usuarioRepository.findByRol(rol.getId());
		
	}
	
	public List<Usuario> getByNombreAndRol(String nombre, Rol rol) {
		
		return (List<Usuario>) usuarioRepository.findByNombreAndRol(nombre, rol.getId());
		
	}
	
	public void delete(Usuario usuario) {
		
		usuarioRepository.deleteById(usuario.getId());
		
	}
	
	public Usuario saveOrUpdate(Usuario user) {
		
		Usuario usuario = usuarioRepository.saveOrUpdate(user);
		return usuario;
		
	}
}
