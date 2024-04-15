package co.edu.unicauca.asae.assttaller.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "docente")
public class Docente extends Persona {
    @Column(name = "correo", length = 30)
    private String correo;
    @Column(name = "vinculacion", length = 30)
    private String vinculacion;
    @Column(name = "departamento", length = 30)
    private String departamento;
    @OneToOne(mappedBy = "idpersona")
    private Telefono idtelefono;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Departamento> departamentos;
}
