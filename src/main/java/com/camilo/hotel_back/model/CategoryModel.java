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
@Table(name = "categories")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ct_name")
    private String name;

    @Size(max = 255)
    @Column(name = "ct_description")
    private String description;
}
