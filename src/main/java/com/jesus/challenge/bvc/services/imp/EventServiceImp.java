package com.jesus.challenge.bvc.services.imp;

import com.jesus.challenge.bvc.models.dto.EventDto;
import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.repositories.EventRepository;
import com.jesus.challenge.bvc.services.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImp implements EventService {
    @Autowired
    private EventRepository eventRepository;
    private  final ModelMapper modelMapper;

    public EventServiceImp(ModelMapper modelMapper) {
        this.modelMapper =modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public EventDto getEventById(Long id) {
        Optional<Event> op =eventRepository.findById(id);
        if(op.isPresent()){
           Event ev = op.get();
            EventDto edto =   modelMapper.map(ev, EventDto.class);
            return edto;
        }else{
            return new EventDto();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventDto> findAll() {
        List<Event> lista =  (List<Event>) eventRepository.findAll();
        if(lista.size() > 0){
            return lista.stream().map(ev -> modelMapper.map(ev, EventDto.class)).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public EventDto addEvent(EventDto eventDto) {
        Event ev = modelMapper.map(eventDto, Event.class);
        ev = eventRepository.save(ev);
        return  modelMapper.map(ev, EventDto.class);
    }

    @Override
    public EventDto updateEvent(Event event) {
        Optional<Event> op =eventRepository.findById(event.getId());
        if(op.isPresent()){
            Event ev = op.get();
            ev.setDescription(event.getDescription());
            ev.setIdEvent(event.getIdEvent());
            ev.setCost(event.getCost());
            Event eg = eventRepository.save(ev);
            EventDto edto =   modelMapper.map(eg, EventDto.class);
            return edto;
        }else{
            return new EventDto();
        }
    }

    @Override
    public void removeEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
