package com.springboot.monolito.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="EmpresaDto") // esto es para especificar el nombre en la BD
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "razon_social", length = 100) // Esto solo en BD
    private String razonSocial; // en POstman se utiliza "razonSocial"
    private String ruc;
    private String representante;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion", length = 100)
    private Date fechaCreacion;

    @Transient // esto es para no mapear en la BD
    private String puerto;

}
