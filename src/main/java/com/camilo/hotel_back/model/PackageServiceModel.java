package com.camilo.hotel_back.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packages_services")
public class PackageServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pksv_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pksv_pk_id", referencedColumnName = "pk_id", nullable = false)
    private PackageModel packageModel;

    @ManyToOne
    @JoinColumn(name = "pksv_sv_id", referencedColumnName = "sv_id", nullable = false)
    private ServiceModel serviceModel;
}
