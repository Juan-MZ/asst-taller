package co.edu.unicauca.asae.assttaller.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Integer idPregunta;

    @Column(length = 60, nullable = false)
    private String enunciado;

    @OneToMany(cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "objPregunta")
    private List<Respuesta> respuestas;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "id_cuestionario", nullable = false)
    private Cuestionario objCuestionario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pregunta", nullable = false)
    private TipoPregunta objTipoPregunta;
}
