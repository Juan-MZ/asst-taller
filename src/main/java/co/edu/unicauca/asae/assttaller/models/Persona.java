package co.edu.unicauca.asae.assttaller.models;

import co.edu.unicauca.asae.assttaller.models.enums.TipoIdentificacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idpersona_seq")
    @SequenceGenerator(name = "idpersona_seq", sequenceName = "idpersona_seq", allocationSize = 1)
    @Column(name = "idpersona", length = 10)
    private Integer personaId;

    @Enumerated(EnumType.STRING) // Mapea el enum como una cadena en la base de datos
    @Column(name = "tipoidentificacion", length = 30)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "numeroidentificacion", length = 30)
    private String numeroIdentificacion;

    @Column(name = "nombres", length = 30)
    private String nombres;

    @Column(name = "apellidos", length = 30)
    private String apellidos;

}
