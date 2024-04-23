package co.edu.unicauca.asae.assttaller.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_preguntas")
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pregunta")
    private Integer idTipoPregunta;

    @Column(length = 30)
    private String nombre;

    @Column(length = 60)
    private String descripcion;

    @OneToMany(cascade = { CascadeType.REMOVE },
        fetch = FetchType.EAGER, mappedBy = "objTipoPregunta")
    private List<Pregunta> preguntas;
}
