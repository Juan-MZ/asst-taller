package co.edu.unicauca.asae.assttaller.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuestionarios")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuestionario")
    private Integer idCuestionario;

    @Column(length = 30)
    private String titulo;

    @Column(length = 30)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objCuestionario")
    private List<Pregunta> preguntas;
}
