package com.example.joyas.service.impl;

import com.example.joyas.dto.request.CreateJewelryDto;
import com.example.joyas.dto.request.UpdateJewelryDto;
import com.example.joyas.dto.response.ListJewelryDto;
import com.example.joyas.dto.response.MessageDto;
import com.example.joyas.entity.Jewelry;
import com.example.joyas.exception.NotFoundException;
import com.example.joyas.repository.IJewelryRepository;
import com.example.joyas.service.IJewelryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService implements IJewelryService {
    private final IJewelryRepository iJewelryRepository;
    private final ObjectMapper objectMapper;

    public JewelryService(IJewelryRepository iJewelryRepository, ObjectMapper objectMapper) {
        this.iJewelryRepository = iJewelryRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public MessageDto create(CreateJewelryDto createJewelryDto) {
        Jewelry newJewelry = this.iJewelryRepository.save(
                this.objectMapper.convertValue(createJewelryDto, Jewelry.class)
        );
        return new MessageDto("Jewelry created with id: " + newJewelry.getId());
    }

    @Override
    public List<ListJewelryDto> list() {
        return this.iJewelryRepository
                .findAll()
                .stream()
                .map((j) -> objectMapper.convertValue(j, ListJewelryDto.class))
                .toList();
    }

    @Override
    public MessageDto delete(Long id) {
        Optional<Jewelry> jewelry = this.iJewelryRepository.findById(id);
        if(jewelry.isEmpty())
            throw new NotFoundException("jewelry not found");
        this.iJewelryRepository.delete(jewelry.get());
        return new MessageDto("Jewelry deleted successfully");
    }

    @Override
    public ListJewelryDto update(Long id, UpdateJewelryDto updateJewelryDto) {
        Optional<Jewelry> jewelry = this.iJewelryRepository.findById(id);
        if(jewelry.isEmpty())
            throw new NotFoundException("jewelry not found");
        Jewelry jewelryToUpdate = jewelry.get();
        if(updateJewelryDto.name() != null)
            jewelryToUpdate.setName(updateJewelryDto.name());
        if(updateJewelryDto.material() != null)
            jewelryToUpdate.setMaterial(updateJewelryDto.material());
        if(updateJewelryDto.weight() != null)
            jewelryToUpdate.setWeight(updateJewelryDto.weight());
        if(updateJewelryDto.specification() != null)
            jewelryToUpdate.setSpecification(updateJewelryDto.specification());
        if(updateJewelryDto.hasStone() != null)
            jewelryToUpdate.setHasStone(updateJewelryDto.hasStone());
        if(updateJewelryDto.isAvailableForSale() != null)
            jewelryToUpdate.setIsAvailableForSale(updateJewelryDto.isAvailableForSale());
        this.iJewelryRepository.save(jewelryToUpdate);
        return this.objectMapper.convertValue(jewelryToUpdate, ListJewelryDto.class);
    }
}
