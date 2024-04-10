package co.edu.unicauca.asae.assttaller.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "docente")
public class Docente extends Persona{
    @Column(name = "correo", length = 30)
    private String correo;
    @Column(name = "vinculacion", length = 30)
    private String vinculacion;
    @Column(name = "departamento", length = 30)
    private String departamento;
}
