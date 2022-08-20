package com.jesus.challenge.bvc.models.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_event")
    private String idEvent;
    @Column(name="description")
    private String description;
    @Column(name="amount")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="platform_id", nullable=false, updatable=false) //
    private Platform platform;

}
