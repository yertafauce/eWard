package eWard.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String contrasena;
	
	@ManyToOne
	@JoinColumn(name = "idRol")
	private Rol rol;
	
}
