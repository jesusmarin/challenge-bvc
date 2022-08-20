package com.jesus.challenge.bvc.controllers;

import com.jesus.challenge.bvc.models.dto.EventDto;
import com.jesus.challenge.bvc.services.imp.EventServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class BvcController {
    private final EventServiceImp eventService;

    //-----Eventos--------------------------

    /** guardar tipo evento
     * @param ed EventDto
     * @return EventDto.Class
     */
    @PostMapping(value = "/")
    public EventDto saveEvent(@RequestBody EventDto ed){
        return eventService.addEvent(ed);
    }

    /**
     * * busca evento por id
     * @param id
     * @return EventDto
     */
    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable("id") Integer id){
        return eventService.getEventById(id.longValue());
    }

    @GetMapping("/")
    public List<EventDto> findAllEvent(){
        return eventService.findAll();
    }



}
