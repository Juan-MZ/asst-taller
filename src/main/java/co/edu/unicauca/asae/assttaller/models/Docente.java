package co.edu.unicauca.asae.assttaller.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id_docente")
@Table(name = "docentes")
public class Docente extends Persona {

    @Column(length = 30, nullable = false)
    private String correo;

    @Column(length = 30)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objPersona")
    private Telefono objTelefono;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "departamentos-docentes",
                joinColumns = @JoinColumn(name = "id_persona"),
                inverseJoinColumns = @JoinColumn(name = "id_departamento"))
    private List<Departamento> departamentos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<Respuesta> respuestas; 
}
