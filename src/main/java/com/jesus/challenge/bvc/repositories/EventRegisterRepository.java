package com.jesus.challenge.bvc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.jesus.challenge.bvc.models.entities.EventRegister;

import java.util.List;

public interface EventRegisterRepository extends CrudRepository<EventRegister, Long> {

    @Query("select er from EventRegister er where er.date>?1 and er.date<?2")//and er.date<?2
    List<EventRegister> findBetweenDate(Long start, Long end);

    @Query("select count(er) from EventRegister er where er.date>?1 and er.date<?2")//and er.date<?2
    Integer countBetweenDate(Long start, Long end);
}
