package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.AcquisitionDTO;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.services.AcquisitionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/acquisition")
@Tag(name = "Acquisition", description = "Rest operations of product purchases by the client")
public class AcquisitionController {

    private final AcquisitionService acquisitionService;

    @Operation(summary = "Get a acquisition by id")
    @GetMapping("/{id}")
    public AcquisitionDTO findById(@PathVariable Long id) {
        return acquisitionService.findById(id);
    }

    @Operation(summary = "Get all acquistions")
    @GetMapping
    public List<AcquisitionDTO> findAll() {
        return acquisitionService.findAll();
    }

    @Operation(summary = "Make a product acquisition ")
    @PostMapping
    public AcquisitionDTO include(@RequestBody @Valid AcquisitionDTO acquisitionDTO) {
        return acquisitionService.include(acquisitionDTO);
    }

    @Operation(summary = "Modify the acquisition status")
    public AcquisitionStatus modifyAcquisitionStatus(@PathVariable @Valid Long id,
            @RequestBody AcquisitionDTO acquisitionDTO) {
        return acquisitionService.modifyAcquisitionStatus(id, acquisitionDTO);
    }

}
