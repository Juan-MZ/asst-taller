package co.edu.unicauca.asae.assttaller.models;

import co.edu.unicauca.asae.assttaller.models.enums.TipoIdentificacion;
import co.edu.unicauca.asae.assttaller.models.enums.TipoTelefono;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "telefono")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtelefono_seq")
    @SequenceGenerator(name = "idtelefono_seq", sequenceName = "idtelefono_seq", allocationSize = 1)
    @Column(name = "idtelefono", length = 10)
    private Integer telefonoId;

    @Enumerated(EnumType.STRING) // Mapea el enum como una cadena en la base de datos
    @Column(name = "tipotelefono", length = 30)
    private TipoTelefono tipoTelefono;

    @Column(name = "tipotelefono", length = 30)
    private String numero;

    @OneToOne
    @JoinColumn(name = "idpersona")
    private Docente idpersona;
}
