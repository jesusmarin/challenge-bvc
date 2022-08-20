package com.jesus.challenge.bvc.services.imp;

import com.jesus.challenge.bvc.models.dto.EventRegisterDto;
import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.EventRegister;
import com.jesus.challenge.bvc.models.entities.Platform;
import com.jesus.challenge.bvc.repositories.EventRegisterRepository;
import com.jesus.challenge.bvc.services.EventRegisterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EventRegisterServiceImp implements EventRegisterService {

    private  final EventRegisterRepository repository;
    private  final ModelMapper modelMapper;

    /**
     * *
     * @param id
     * @return EventRegisterDto
     */
    @Override
    @Transactional(readOnly = true)
    public EventRegisterDto getEventRegisterById(Long id) {
        Optional<EventRegister> op = repository.findById(id);
        if(op.isPresent()){
            EventRegister er = op.get();
            return modelMapper.map(er, EventRegisterDto.class);
       }else{
            return new EventRegisterDto();
        }
    }

    /**
     * *
     * @return  List<EventRegisterDto>
     */
    @Override
    @Transactional(readOnly = true)
    public List<EventRegisterDto> findAll() {
        List<EventRegister> lista = (List<EventRegister>) repository.findAll();
        if(lista.size()>0){
            return lista.stream().map(er -> modelMapper.map(er, EventRegisterDto.class)).collect(Collectors.toList());
        }else{
            return null;
        }
    }

    /**
     * *
     * @param dto
     * @return EventRegisterDto
     */
    @Override
    public EventRegisterDto addEventRegister(EventRegisterDto dto) {
        EventRegister er = modelMapper.map(dto, EventRegister.class);
        BigDecimal cst = (dto.getEvent().getCost().multiply(BigDecimal.valueOf(dto.getAmount().doubleValue())));
        er.setCost(cst);
        er.setDate(System.currentTimeMillis()/1000);
        EventRegister erdb = repository.save(er);
        return modelMapper.map(erdb, EventRegisterDto.class);
    }

    @Override
    public EventRegisterDto updateEventRegister(EventRegisterDto dto) {
        Optional<EventRegister> op = repository.findById(dto.getId());
        if(op.isPresent()){
            EventRegister er = op.get();
            BigDecimal cst = (dto.getEvent().getCost().multiply(BigDecimal.valueOf(dto.getAmount().doubleValue())));
            er.setAmount(dto.getAmount());
            er.setCost(cst);
            return modelMapper.map(er, EventRegisterDto.class);
        }else{
            return new EventRegisterDto();//throw new Exception("Exception message");;
        }
    }

    @Override
    public void removeEventRegister(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate) {
        return null;
    }

    @Override
    public List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate, Event e) {
        return null;
    }

    @Override
    public List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate, Platform p) {
        return null;
    }

    @Override
    public List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate, Event e, Platform p) {
        return null;
    }

    @Override
    public Integer countBetweenDate(Long startDate, Long endDate) {
        return null;
    }

    @Override
    public Integer countBetweenDate(Long startDate, Long endDate, Event e) {
        return null;
    }

    @Override
    public Integer countBetweenDate(Long startDate, Long endDate, Platform p) {
        return null;
    }

    @Override
    public Integer countBetweenDate(Long startDate, Long endDate, Event e, Platform p) {
        return null;
    }
}
