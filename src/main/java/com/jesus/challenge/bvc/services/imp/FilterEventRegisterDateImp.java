package com.jesus.challenge.bvc.services.imp;

import com.jesus.challenge.bvc.models.dto.BetweenDateEventPlatformDto;
import com.jesus.challenge.bvc.models.dto.EventRegisterDto;
import com.jesus.challenge.bvc.models.entities.EventRegister;
import com.jesus.challenge.bvc.repositories.EventRegisterRepository;
import com.jesus.challenge.bvc.services.FilterEventRegister;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FilterEventRegisterDateImp implements FilterEventRegister {
    private  final EventRegisterRepository repository;
    private  final ModelMapper modelMapper;
    @Override
    public List<EventRegisterDto> findBetweenDate(BetweenDateEventPlatformDto dto) {
        List<EventRegister> lista = new ArrayList<>();
        //no son null event y platform
        if((dto.getEvent().getIdEvent()!=null && dto.getEvent().getIdEvent().length()>1)
            &&(dto.getPlatform().getName()!=null && dto.getPlatform().getName().length()>1)
        ){
            lista = (List<EventRegister>) repository.findBetweenDate(dto.getStart(), dto.getEnd(), dto.getEvent(), dto.getPlatform());
        }else if(dto.getEvent().getIdEvent()!=null && dto.getEvent().getIdEvent().length()>1) { //null platform
            lista = (List<EventRegister>) repository.findBetweenDate(dto.getStart(), dto.getEnd(), dto.getEvent());
        }else if(dto.getPlatform().getName()!=null && dto.getPlatform().getName().length()>1) {//null event
            lista = (List<EventRegister>) repository.findBetweenDate(dto.getStart(), dto.getEnd(), dto.getEvent());
        }else{
         lista = (List<EventRegister>) repository.findBetweenDate(dto.getStart(), dto.getEnd());
        }

        if(lista.size()>0){
            return lista.stream().map(er -> modelMapper.map(er, EventRegisterDto.class)).collect(Collectors.toList());
        }else{
            return null;
        }
    }

    @Override
    public Integer countBetweenDate(BetweenDateEventPlatformDto dto) {
        if((dto.getEvent().getIdEvent()!=null && dto.getEvent().getIdEvent().length()>1)
                &&(dto.getPlatform().getName()!=null && dto.getPlatform().getName().length()>1)
        ){
           return repository.countBetweenDate(dto.getStart(), dto.getEnd(), dto.getEvent(), dto.getPlatform());
        }else if(dto.getEvent().getIdEvent()!=null && dto.getEvent().getIdEvent().length()>1) { //null platform
            return repository.countBetweenDate(dto.getStart(), dto.getEnd(), dto.getEvent());
        }else if(dto.getPlatform().getName()!=null && dto.getPlatform().getName().length()>1) {//null event
            return repository.countBetweenDate(dto.getStart(), dto.getEnd(), dto.getEvent());
        }else{
            return repository.countBetweenDate(dto.getStart(), dto.getEnd());
        }

    }
}
