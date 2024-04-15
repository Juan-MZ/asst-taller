package co.edu.unicauca.asae.assttaller.models;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@AllArgsConstructor
public class Departamento {

    @Column(name = "iddepartamento")
    private Integer idDepartamento;

    @Column(name = "nombredep", length = 30)
    private String nombreDep;

    @Column(length = 30)
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Docente> docentes;
}
