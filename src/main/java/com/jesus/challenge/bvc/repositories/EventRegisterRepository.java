package com.jesus.challenge.bvc.repositories;

import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.Platform;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.jesus.challenge.bvc.models.entities.EventRegister;

import java.util.List;

public interface EventRegisterRepository extends CrudRepository<EventRegister, Long> {

    @Query("select er from EventRegister er where er.date>?1 and er.date<?2")
    List<EventRegister> findBetweenDate(Long start, Long end);

    @Query("select er from EventRegister er where er.date>?1 and er.date<?2 and er.event=?3")
    List<EventRegister> findBetweenDate(Long start, Long end, Event ev);

    @Query("select er from EventRegister er where er.date>?1 and er.date<?2 and er.platform=?3")
    List<EventRegister> findBetweenDate(Long start, Long end, Platform p);
    @Query("select er from EventRegister er where er.date>?1 and er.date<?2 and er.event=?3 and er.platform=?4")
    List<EventRegister> findBetweenDate(Long start, Long end, Event e, Platform p);

    @Query("select count(er) from EventRegister er where er.date>?1 and er.date<?2")
    Integer countBetweenDate(Long start, Long end);
    @Query("select count(er) from EventRegister er where er.date>?1 and er.date<?2 and er.event=?3")
    Integer countBetweenDate(Long start, Long end, Event e);
    @Query("select count(er) from EventRegister er where er.date>?1 and er.date<?2 and er.platform=?3")
    Integer countBetweenDate(Long start, Long end, Platform p);
    @Query("select count(er) from EventRegister er where er.date>?1 and er.date<?2 and er.event=?3 and er.platform=?4")
    Integer countBetweenDate(Long start, Long end, Event e, Platform p);
}
