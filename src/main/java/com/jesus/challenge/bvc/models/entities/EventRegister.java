package com.jesus.challenge.bvc.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "event_register")
public class EventRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="date")
    private Long date;
    @Column(name="amount")
    private Integer amount;
    @Column(name="cost")
    private Integer cost;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="platform_id", nullable=false, updatable=false) //
    private Platform platform;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id", nullable=false, updatable=false) //
    private Event event;

}
