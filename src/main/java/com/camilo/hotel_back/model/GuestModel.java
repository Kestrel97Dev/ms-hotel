package com.camilo.hotel_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "guests")
public class GuestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gt_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gt_pt_id", referencedColumnName = "pt_id", nullable = false)
    private PatientModel patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gt_rm_id", referencedColumnName = "rm_id", nullable = false)
    private RoomModel room;

    @NotNull
    @Column(name = "gt_entry_date")
    private Date entryDate;

    @NotNull
    @Column(name = "gt_exit_date")
    private Date exitDate;
}
