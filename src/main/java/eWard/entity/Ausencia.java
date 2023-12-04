package eWard.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ausencia")
public class Ausencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date fecha;
	
	@Column
	private boolean justificada;
	
	@ManyToOne
	@JoinColumn(name = "idCurso")
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
}
