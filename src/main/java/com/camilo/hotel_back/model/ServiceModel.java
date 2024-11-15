package com.camilo.hotel_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class ServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sv_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sv_name")
    private String name;

    @Size(max = 255)
    @Column(name = "sv_description")
    private String description;

    @NotNull
    @Column(name = "sv_cost")
    private Double cost;
}
