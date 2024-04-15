package co.edu.unicauca.asae.assttaller.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TipoPregunta {
    private Integer idtippregunta;
    private String nombre;
    private String descripcion;
}
