package com.Berkay.InterProbe.InterProbeBootcamp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productComments"})
public class Product {

    @Id
    @GeneratedValue(generator = "Products", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Products", sequenceName = "PRODUCTS_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "PRICE", precision = 15, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "product"
    )
    private Set<ProductComment> productComments = new HashSet<>();;

}