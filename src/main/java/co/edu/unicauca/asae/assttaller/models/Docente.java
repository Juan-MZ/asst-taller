package co.edu.unicauca.asae.assttaller.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id_persona")
@Table(name = "docentes")
public class Docente extends Persona {

    @Column(length = 30, nullable = false)
    private String correo;

    @Column(length = 30)
    private String vinculacion;

    @OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "objPersona")
    private Telefono objTelefono;

    @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinTable(name = "departamentos-docentes",
                joinColumns = @JoinColumn(name = "id_persona"),
                inverseJoinColumns = @JoinColumn(name = "id_departamento"))
    private List<Departamento> departamentos;

    @OneToMany(cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<Respuesta> respuestas; 
}
