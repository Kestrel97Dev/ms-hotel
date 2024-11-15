package com.camilo.hotel_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packages")
public class PackageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long id;

    @Column(name = "pk_name", nullable = false, length = 100)
    private String name;

    @Column(name = "pk_total_cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCost;

    @NotNull
    @Column(name = "pk_days")
    private Integer days;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pk_description")
    private String description;
}
