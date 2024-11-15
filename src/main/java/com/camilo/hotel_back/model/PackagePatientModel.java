package com.camilo.hotel_back.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "packages_patients")
public class PackagePatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkpt_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pkpt_pk_id", referencedColumnName = "pk_id", nullable = false)
    private PackageModel packageModel;

    @ManyToOne
    @JoinColumn(name = "pkpt_pt_id", referencedColumnName = "pt_id", nullable = false)
    private PatientModel patientModel;

    @Column(name = "pkpt_purchase_date", nullable = false)
    private Date purchaseDate;
}
