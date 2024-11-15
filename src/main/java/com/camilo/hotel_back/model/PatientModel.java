package com.camilo.hotel_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "patients")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pt_first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pt_last_name")
    private String lastName;

    @Size(max = 20)
    @Column(name = "pt_gender")
    private String gender;

    @NotNull
    @Column(name = "pt_birth_date")
    private Date birthDate;

    @Size(max = 100)
    @Column(name = "pt_nationality")
    private String nationality;

    @Column(name = "pt_address")
    private String address;

    @Size(max = 10)
    @Column(name = "pt_phone_number")
    private String phoneNumber;

    @Size(max = 100)
    @Column(name = "pt_email")
    private String email;

    @Column(name = "pt_medical_info")
    private String medicalInfo;

    @Lob
    @Column(name = "pt_profile_picture")
    private byte[] profilePicture;

}