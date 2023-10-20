package br.com.telmo.cambioservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cambio", schema = "cambio_service")
@Entity
public class Cambio implements Serializable {

    private static final long serialVersionUID = 2847026927573075543L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMBIO_SEQ")
    @SequenceGenerator(name = "CAMBIO_SEQ", sequenceName = "CAMBIO_SEQ", schema = "CAMBIO_SERVICE", allocationSize = 1)
    private Long id;

    @Column(name= "FROM_CURRENCY", nullable = false, length = 3)
    private String from;

    @Column(name= "TO_CURRENCY", nullable = false, length = 3)
    private String to;

    @Column(name= "CONVERSION_FACTORY", nullable = false)
    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal converterdValue;

    @Transient
    private String enviroment;

}
