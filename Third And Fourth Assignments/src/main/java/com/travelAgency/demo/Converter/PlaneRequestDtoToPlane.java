package com.travelAgency.demo.Converter;

import com.travelAgency.demo.Dto.Plane.PlaneRequestDto;
import com.travelAgency.demo.Model.Plane;
import org.springframework.stereotype.Component;

@Component
public class PlaneRequestDtoToPlane {
    public Plane convertPlaneRequestDtoToPlane(PlaneRequestDto planeRequestDto){

        Plane plane = new Plane();
        plane.setPlaneName(planeRequestDto.getPlaneName());
        plane.setCapacity(planeRequestDto.getCapacity());

        return plane;
    }
}
