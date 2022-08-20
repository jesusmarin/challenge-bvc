package com.jesus.challenge.bvc.repositories;

import com.jesus.challenge.bvc.models.entities.Event;
import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository <Event, Long> {
}