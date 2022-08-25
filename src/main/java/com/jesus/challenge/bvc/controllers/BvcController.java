package com.jesus.challenge.bvc.controllers;

import com.jesus.challenge.bvc.models.dto.*;
import com.jesus.challenge.bvc.services.EventRegisterService;
import com.jesus.challenge.bvc.services.EventService;
import com.jesus.challenge.bvc.services.FilterEventRegister;
import com.jesus.challenge.bvc.services.PlatformService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BvcController {
    private final EventService eventService;
    private final PlatformService platformService;
    private final EventRegisterService evRegisterService;
    private final FilterEventRegister filterService;

    //-----Eventos--------------------------

    /** guardar tipo evento
     * @param ed EventDto
     * @return EventDto.Class
     */
    @PostMapping(value = "/events")
    public EventDto saveEvent(@RequestBody EventDto ed){
        return eventService.addEvent(ed);
    }

    /**
     * * busca evento por id
     * @param id
     * @return EventDto
     */
    @GetMapping("/events/{id}")
    public EventDto getEventById(@PathVariable("id") Integer id){
        return eventService.getEventById(id.longValue());
    }

    @GetMapping("/events")
    public List<EventDto> findAllEvent(){
        return eventService.findAll();
    }

 //-----Plataformas--------------------------

    /**
     * @param dto
     * @return PlatformDto
     */
    @PostMapping(value = "/platforms")
    public PlatformDto savePlatform(@RequestBody PlatformDto dto){
     return platformService.addPlatform(dto);
    }

    /**
     * *
     * @param id
     * @return PlatformDto
     */
    @GetMapping("/platforms/{id}")
    public PlatformDto getPlatformsById(@PathVariable("id") Integer id){
        return platformService.getPlatformById(id.longValue());
    }

    /**
     * *
     * @return List<PlatformDto>
     */
    @GetMapping("/platforms")
    public List<PlatformDto> findAllPlatforms(){
        return platformService.findAll();
    }

    //----- Registro de Eventos -------------------------

    /**
     * *
     * @param dto
     * @return EventRegisterDto
     */
    @PostMapping(value = "/event-register")
    public EventRegisterDto saveEventRegister(@RequestBody EventRegisterDto dto){
        return evRegisterService.addEventRegister(dto);
    }

    /**
     * *
     * @param id
     * @return EventRegisterDto
     */
    @GetMapping("/event-register/{id}")
    public EventRegisterDto getEventRegisterById(@PathVariable("id") Integer id){
        return evRegisterService.getEventRegisterById(id.longValue());
    }

    /**
     * *
     * @return List<EventRegisterDto>
     */
    @GetMapping("/event-register")
    public List<EventRegisterDto> findAllEventRegister(){
        return evRegisterService.findAll();
    }

    /**
     * @param dto BetweenDateEventPlatformDto
     * @return List<EventRegisterDto>
     */
    @PostMapping("/event-register/date-event-plat")

        public List<EventRegisterDto> findBetweenDate(@RequestBody BetweenDateEventPlatformDto dto){
            return filterService.findBetweenDate(dto);
    }



    /**
     * @param dto BetweenDateEventPlatformDto
     * @return Integer
     */
    @GetMapping("/event-register/count-event-plat")
        public Integer countBetweenDateEventPlatform(@RequestBody BetweenDateEventPlatformDto dto){
        return filterService.countBetweenDate(dto);
    }

}
