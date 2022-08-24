package com.jesus.challenge.bvc.controllers;

import com.jesus.challenge.bvc.models.dto.*;
import com.jesus.challenge.bvc.services.EventRegisterService;
import com.jesus.challenge.bvc.services.EventService;
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
     * @param dto BetweenDateDto
     * @return List<EventRegisterDto>
     */
    @GetMapping("/event-register/date")
    public List<EventRegisterDto> findBetweenDate(@RequestBody BetweenDateDto dto){
        return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue());
    }
    /**
     * @param dto BetweenDateEventDto
     * @return List<EventRegisterDto>
     */
    @GetMapping("/event-register/date-event")
        public List<EventRegisterDto> findBetweenDate(@RequestBody BetweenDateEventDto dto){
            return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getEvent());
    }
    /**
     * @param dto BetweenDatePlatformDto
     * @return List<EventRegisterDto>
     */
    @GetMapping("/event-register/date-plat")
        public List<EventRegisterDto> findBetweenDate(@RequestBody BetweenDatePlatformDto dto){
            return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getPlatform());
    }
    /**
     * @param dto BetweenDateEventPlatformDto
     * @return List<EventRegisterDto>
     */
    @PostMapping("/event-register/date-event-plat")

        public List<EventRegisterDto> findBetweenDate(@RequestBody BetweenDateEventPlatformDto dto){
               System.out.println("start peticion ->"+dto.toString());
        if((dto.getEvent().getIdEvent() != null && dto.getEvent().getIdEvent().length()>0) && (dto.getPlatform().getName() != null && dto.getPlatform().getName().length()>0)){
            System.out.println("con todos los datos 1");
            return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getEvent(), dto.getPlatform());
        }else  if(dto.getEvent().getIdEvent() != null  && dto.getEvent().getIdEvent().length()>0){
            System.out.println("con event los datos 2");
            return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getEvent());
        }else if(dto.getPlatform().getName() != null && dto.getPlatform().getName().length()>0){
            System.out.println("con platfomr los datos 3");
            return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getPlatform());
        }else{
            System.out.println("con fechas los datos 4");
            return evRegisterService.findBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue());
        }
    }

    /**
     * @param dto BetweenDateDto
     * @return Integer
     */
    @GetMapping("/event-register/count")
    public Integer countBetweenDate(@RequestBody BetweenDateDto dto){
        return evRegisterService.countBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue());
    }
    /**
     * @param dto BetweenDateEventDto
     * @return Integer
     */
    @GetMapping("/event-register/count-event")
    public Integer countBetweenDateEvent(@RequestBody BetweenDateEventDto dto){
        return evRegisterService.countBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getEvent());
    }
    /**
     * @param dto BetweenDatePlatformDto
     * @return Integer
     */
    @GetMapping("/event-register/count-plat")
    public Integer countBetweenDatePlatform(@RequestBody BetweenDatePlatformDto dto){
        return evRegisterService.countBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getPlatform());
    }
    /**
     * @param dto BetweenDateEventPlatformDto
     * @return Integer
     */
    @GetMapping("/event-register/count-event-plat")
        public Integer countBetweenDateEventPlatform(@RequestBody BetweenDateEventPlatformDto dto){
        return evRegisterService.countBetweenDate(dto.getStart().longValue(), dto.getEnd().longValue(), dto.getEvent(), dto.getPlatform());
    }

}
