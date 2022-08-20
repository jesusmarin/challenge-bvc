package com.jesus.challenge.bvc.controllers;

import com.jesus.challenge.bvc.models.dto.EventDto;
import com.jesus.challenge.bvc.models.dto.PlatformDto;
import com.jesus.challenge.bvc.services.EventService;
import com.jesus.challenge.bvc.services.PlatformService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BvcController {
    private final EventService eventService;
    private final PlatformService platformService;

    //-----Eventos--------------------------

    /** guardar tipo evento
     * @param ed EventDto
     * @return EventDto.Class
     */
    @PostMapping(value = "/events/")
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

    @GetMapping("/events/")
    public List<EventDto> findAllEvent(){
        return eventService.findAll();
    }

 //-----Plataformas--------------------------

    /**
     * @param dto
     * @return PlatformDto
     */
    @PostMapping(value = "/platforms/")
    public PlatformDto savePlatform(@RequestBody PlatformDto dto){
     return platformService.addPlatform(dto);
    }

    @GetMapping("/platforms/{id}")
    public PlatformDto getPlatformsById(@PathVariable("id") Integer id){
        return platformService.getPlatformById(id.longValue());
    }

    @GetMapping("/platforms/")
    public List<PlatformDto> findAllPlatforms(){
        return platformService.findAll();
    }

    //----- Registro de Eventos -------------------------
}
