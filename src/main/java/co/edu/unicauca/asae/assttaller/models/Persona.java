package co.edu.unicauca.asae.assttaller.models;

import co.edu.unicauca.asae.assttaller.models.enums.TipoIdentificacion;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Enumerated(EnumType.STRING) // Mapea el enum como una cadena en la base de datos
    @Column(name = "tipo_identificacion", length = 30)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "numero_identificacion", length = 30)
    private String numeroIdentificacion;

    @Column(length = 30)
    private String nombres;

    @Column(length = 30)
    private String apellidos;
}
