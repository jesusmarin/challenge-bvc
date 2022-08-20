package com.jesus.challenge.bvc.services.imp;

import com.jesus.challenge.bvc.models.dto.PlatformDto;
import com.jesus.challenge.bvc.models.entities.Platform;
import com.jesus.challenge.bvc.repositories.PlatformRepository;
import com.jesus.challenge.bvc.services.PlatformService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PlatformServiceImp implements PlatformService {

    private final PlatformRepository platformRepository;
    private  final ModelMapper modelMapper;

    /**
     * *
     * @param id
     * @return PlatformDto
     */
    @Override
    @Transactional(readOnly = true)
    public PlatformDto getPlatformById(Long id) {
        Optional<Platform> op = platformRepository.findById(id);
        if(op.isPresent()){
            Platform pl = op.get()
;            return modelMapper.map(pl, PlatformDto.class);
        }
        return new PlatformDto();
    }

    /**
     * *
     * @return List<PlatformDto>
     */
    @Override
    @Transactional(readOnly = true)
    public List<PlatformDto> findAll() {
        List<Platform> lista = (List<Platform>) platformRepository.findAll();
        if(lista.size() > 0){
            return lista.stream().map(pl -> modelMapper.map(pl, PlatformDto.class)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * *
     * @param dto
     * @return PlatformDto
     */
    @Override
    public PlatformDto addPlatform(PlatformDto dto) {
       Platform npl =  modelMapper.map(dto, Platform.class);
       Platform pbd = platformRepository.save(npl);
       return modelMapper.map(pbd, PlatformDto.class);
    }

    /**
     * *
     * @param dto
     * @return PlatformDto
     */
    @Override
    public PlatformDto updatePlatform(PlatformDto dto) {
        Optional<Platform> op = platformRepository.findById(dto.getId());
        if(op.isPresent()){
            Platform pl = op.get();
            pl.setDecription(dto.getDecription());
            pl.setName(dto.getName());
            Platform pls = platformRepository.save(pl);
            return modelMapper.map(pls, PlatformDto.class);
        }
        return new PlatformDto();
    }

    @Override
    public void removePlatform(Long id) {
    }
}
