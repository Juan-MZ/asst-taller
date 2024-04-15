package co.edu.unicauca.asae.assttaller.models;

import co.edu.unicauca.asae.assttaller.models.enums.TipoTelefono;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telefonos")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private Integer idTelefono;

    @Enumerated(EnumType.STRING) // Mapea el enum como una cadena en la base de datos
    @Column(name = "tipo_telefono", length = 30)
    private TipoTelefono tipoTelefono;

    @Column(length = 30)
    private String numero;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Docente objPersona;
}
