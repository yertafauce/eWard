package eWard.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dni;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@ManyToOne
	@JoinColumn(name = "idCurso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

}
