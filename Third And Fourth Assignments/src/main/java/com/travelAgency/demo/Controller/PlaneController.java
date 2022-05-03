package com.travelAgency.demo.Controller;

import com.travelAgency.demo.Dto.Plane.PlaneRequestDto;
import com.travelAgency.demo.Dto.Plane.PlaneResponseDto;
import com.travelAgency.demo.Service.PlaneService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/planes")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save-plane")
    public Integer createPlane(@RequestBody PlaneRequestDto planeRequestDto){
        int planeId = planeService.savePlane(planeRequestDto);
        return planeId;
    }

    @DeleteMapping("/delete/{planeId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlane(@PathVariable int planeId){
        planeService.deletePlane(planeId);
    }

    @GetMapping
    public ResponseEntity<List<PlaneResponseDto>> getAllPlanes(){
        List<PlaneResponseDto> planeResponseDtoList = planeService.findAll();
        return new ResponseEntity<>(planeResponseDtoList, HttpStatus.OK);
    }
}
