package com.jesus.challenge.bvc.repositories;

import org.springframework.data.repository.CrudRepository;
import com.jesus.challenge.bvc.models.entities.EventRegister;

public interface EventRegisterRepository extends CrudRepository<EventRegister, Long> {
}
