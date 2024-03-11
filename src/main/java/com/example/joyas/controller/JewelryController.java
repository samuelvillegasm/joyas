package com.example.joyas.controller;

import com.example.joyas.dto.request.CreateJewelryDto;
import com.example.joyas.dto.request.UpdateJewelryDto;
import com.example.joyas.dto.response.ListJewelryDto;
import com.example.joyas.dto.response.MessageDto;
import com.example.joyas.service.IJewelryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    private final IJewelryService iJewelryService;

    public JewelryController(IJewelryService iJewelryService) {
        this.iJewelryService = iJewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> create(
            @Valid @RequestBody CreateJewelryDto createJewelryDto
    ) {
        return new ResponseEntity<MessageDto>(
                this.iJewelryService.create(createJewelryDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ListJewelryDto>> list() {
        return new ResponseEntity<List<ListJewelryDto>>(
                this.iJewelryService.list(),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> delete(
            @PathVariable Long id
    ) {
        return new ResponseEntity<MessageDto>(
                this.iJewelryService.delete(id),
                HttpStatus.OK
        );
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ListJewelryDto> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateJewelryDto updateJewelryDto
    ) {
        return new ResponseEntity<ListJewelryDto>(
                this.iJewelryService.update(id, updateJewelryDto),
                HttpStatus.OK
        );
    }
}
