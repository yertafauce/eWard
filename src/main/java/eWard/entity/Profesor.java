package eWard.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dni;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@ManyToOne
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
}
