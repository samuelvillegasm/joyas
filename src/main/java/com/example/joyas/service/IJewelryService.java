package com.example.joyas.service;

import com.example.joyas.dto.request.CreateJewelryDto;
import com.example.joyas.dto.request.UpdateJewelryDto;
import com.example.joyas.dto.response.ListJewelryDto;
import com.example.joyas.dto.response.MessageDto;
import org.hibernate.sql.Update;

import java.util.List;

public interface IJewelryService {
     public MessageDto create(CreateJewelryDto createJewelryDto);
     public List<ListJewelryDto> list();
     public MessageDto delete(Long id);
     public ListJewelryDto update(Long id, UpdateJewelryDto updateJewelryDto);
}
