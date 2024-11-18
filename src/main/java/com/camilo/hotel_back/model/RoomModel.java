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
@Table(name = "rooms")
public class RoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rm_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rm_ct_id", referencedColumnName = "ct_id", nullable = false)
    private CategoryModel category;

    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "rm_number")
    private String number;

    @NotNull
    @Column(name = "rm_floor")
    private Integer floor;

    @NotNull
    @Column(name = "rm_quota")
    private Integer quota;

    @NotNull
    @Column(name = "rm_cost")
    private Double cost;

    @Size(max = 200)
    @Column(name = "rm_details")
    private String details;

    @NotNull
    @Column(name = "rm_vacant")
    private Boolean vacant;
}