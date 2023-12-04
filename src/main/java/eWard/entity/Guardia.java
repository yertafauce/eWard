package eWard.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "guardia")
public class Guardia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date hora;
	
	@OneToOne
	@JoinColumn(name = "idCurso")
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name = "idProfesor")
	private Profesor profesor;
	
	@ManyToOne
	@JoinColumn(name = "idAusencia")
	private Ausencia ausencia;
	
}
